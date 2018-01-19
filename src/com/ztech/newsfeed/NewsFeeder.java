package com.ztech.newsfeed;

import com.ztech.newsfeeed.delegate.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsFeeder
 */
@WebServlet("/NewsFeeder")
public class NewsFeeder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFeeder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsFeed = null;
		NewsFeedDelegate newsFeedDelegate = new NewsFeedDelegate();
		String genreType = request.getParameter("id");
		response.setContentType("text/html");
		try {
			newsFeed = newsFeedDelegate.getNewsFeed(genreType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("newsFromRSS", newsFeed);
		request.setAttribute("newsCategory", genreType);
		RequestDispatcher rd = request.getRequestDispatcher("/news.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
