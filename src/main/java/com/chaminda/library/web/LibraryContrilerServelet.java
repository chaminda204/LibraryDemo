/**
 * 
 */
package com.chaminda.library.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chaminda.library.delegate.LibraryDelegate;
import com.chaminda.library.domain.Library;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author chamindaa
 * 
 *         date Oct 20, 2012
 */
public class LibraryContrilerServelet extends HttpServlet {

	ApplicationContext applicationContext = null;

	private static final String AJAX_COMMAND_ALLOCATE_BOOKS = "allocateBooks";

	private static final String AJAX_CMD_LOAD_LIBRARIES = "loadLibraries";

	LibraryDelegate libraryDelegate;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Gson jsonConverter = new Gson();

	public void doGet(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse)
			throws ServletException, IOException {

		final String commandName = servletRequest.getParameter("command");

		System.out.println("COMMAND NAME " + commandName);

		if (commandName != null && !commandName.isEmpty()) {
			if (commandName.equals(AJAX_CMD_LOAD_LIBRARIES)) {

				Collection<Library> libraries = libraryDelegate.getAllLibraries();

				servletResponse.setContentType("application/json");

				servletResponse.getWriter().write(jsonConverter.toJson(libraries));

			} else if (commandName.equals(AJAX_COMMAND_ALLOCATE_BOOKS)) {
				String title = null;

				// TODO Transfer this to a sepeate class

				if (servletRequest.getParameter("book_title") != null
						&& !servletRequest.getParameter("book_title").isEmpty()) {
					title = servletRequest.getParameter("book_title");

				}
				int qty = 0;
				if (servletRequest.getParameter("book_Qty") != null
						&& !servletRequest.getParameter("book_Qty").isEmpty()) {
					qty = Integer.parseInt(servletRequest.getParameter("book_Qty"));

				}
				Collection<Library> library = libraryDelegate.allocateBooks(title, qty);
				servletResponse.setContentType("application/json");

				servletResponse.getWriter().write(jsonConverter.toJson(library));

			}
		}

	}

	public void doPost(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse)
			throws ServletException, IOException {
		doGet(servletRequest, servletResponse);

	}

	/**
	 * Loading the app context through Spring.
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		if (applicationContext == null) {
			applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			libraryDelegate = (LibraryDelegate) applicationContext.getBean("libraryDelegate");
		}

	}

}
