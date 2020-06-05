/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.cargaarchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Jaasiel
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        switch (action) {

            case "carga":
                cargarArchivo(request, response);
                break;
            case "descargar":
                descargarArchivo(request, response);
                break;
            case "toupload":
                request.getRequestDispatcher("/cargar.jsp").forward(request, response);
                break;
            case "todownload":
                showFiles(request, response);
                break;
        }

    }

    private void showFiles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        File carpeta = new File("C://archivos/");// carpeta de archivos

        List<Archivo> archivos = new ArrayList<>();

        int no = 1;
        for (File file : carpeta.listFiles()) {

            //obtener el tipo de archivo
            String tipoArchivo = Files.probeContentType(file.toPath());

            archivos.add(new Archivo(no++, file.getName(), tipoArchivo, String.valueOf(file.length())));
        }
        request.setAttribute("dts", archivos);
        request.getRequestDispatcher("/descargar.jsp").forward(request, response);

    }

    private void descargarArchivo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();// objeto de escritura
        String file = request.getParameter("file");//nombre archivo
        String filePath = "C://archivos/";//directorio de archivos

        /*
        * Se configura el tipo de contenido en la respuesta y con setHeader
        * se establece el encabezado al objeto de respuesta, el nombre del
        * archivo que se va descargar
         */
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file + "\"");

        // crear un flujo de entrada en el que se le agrega el archivo y la ruta del mismo
        FileInputStream fileInputStream = new FileInputStream(filePath + file);

        byte[] outputByte = new byte[4096];//bytes leidos

        //este ciclo se usa para leer el archivo y escribirlo en el objeto de escritura
        while (fileInputStream.read(outputByte, 0, 4096) != -1) {
            out.write(outputByte, 0, 4096);
        }

        // cerrar flujos
        fileInputStream.close();
        out.flush();
        out.close();

    }

    private void cargarArchivo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //crear un FileItem
            FileItemFactory fileFactory = new DiskFileItemFactory();

            //covertir los input file en FileItem
            ServletFileUpload servletUp = new ServletFileUpload(fileFactory);

            //lista de FileItem del ServletFileUpload
            List<FileItem> items = servletUp.parseRequest(request);//parsear el request

            // recorrer la lista de FileItem
            for (FileItem itm : items) {

                //este archivo se pasa despues al disco del server
                FileItem item = (FileItem) itm;

                // validar que no sea un text field
                if (!item.isFormField()) {

                    new File("C://archivos/").mkdir();// crear el directorio

                    //ruta del archivo en el server, y se le da un nombre unico
                    File archivoServer = new File("C://archivos/" + UUID.randomUUID() + getExtension(item));

                    //mandar a escribir en el disco del server
                    item.write(archivoServer);

                }
            }

            showFiles(request, response);

        } catch (FileUploadException ex) {
            System.out.println("Error al cargar archivo: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error al cargar archivo: " + ex.getMessage());
        }

    }

    // extraer la extension del archivo cargado
    private String getExtension(FileItem item) {

        String format = "none";
        String fileName = item.getName();
        int index = fileName.lastIndexOf(".");// obtener el indice del punto
        if (index > 0) {
            format = "." + fileName.substring(index + 1);// concatenarle '.' y extraer substring de la extension
            format = format.toLowerCase();// a minusculas
        }

        return format;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
