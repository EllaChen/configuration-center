<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html lang="en">
<head>
<meta charset="utf-8">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-responsive.css" >
<link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
<script src="jquery/jquery.js" type="text/javascript"></script>
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
</head>
<body>

<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap-dropdown.js"></script>
</body>
</html>
