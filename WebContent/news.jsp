<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= request.getAttribute("newsCategory") %>News</title>
<link rel = "stylesheet" type = "text/css" href = "Styles.css"/>
</head>
<body>
	<%@ page
		import="java.io.*, java.net.*, java.util.logging.Logger, org.json.*, com.ztech.newsfeed.NewsFeeder"%>
	<%
	String newsFromRSS = (String) request.getAttribute("newsFromRSS");
	JSONObject object = XML.toJSONObject(newsFromRSS);
	JSONArray jsonArray = (JSONArray) object.get("item");
	for (int i = 0;i < jsonArray.length(); i++) {
		object = (JSONObject) jsonArray.get(i);
	%>
	<h2><%= object.get("title") %></h2>
	<article class = "newsItem">
		<p><%= object.get("description") %></p>
		<a href="<%= object.get("link") %>" class = "external-link">More about this story</a>
	</article>
	<hr/>
	<%
	}
	%>
</body>
</html>