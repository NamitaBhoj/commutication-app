<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from demo.foxthemes.net/instellohtml/feed.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:20:22 GMT -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link href="assets/images/favicon.png" rel="icon" type="image/png">

    <!-- Basic Page Needs
        ================================================== -->
    <title>Social Spark</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Instello - Sharing Photos platform HTML Template">

    <!-- icons
        ================================================== -->
    <link rel="stylesheet" href="assets/css/icons.css">

    <!-- CSS 
        ================================================== -->
    <link rel="stylesheet" href="assets/css/uikit.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/tailwind.css">

</head>

<body>
<div id="wrapper">

   <div class="main_content">

            <div class="container m-auto">
			   <h1 class="lg:text-2xl text-lg font-extrabold leading-none text-gray-900 tracking-tight mb-5" style = "text-align: center;"> Friend List </h1>
                <div class="lg:flex justify-center lg:space-x-10 lg:space-y-0 space-y-5">
                    <div class="space-y-5 flex-shrink-0 lg:w-7/12">
						<tag:forEach var="post" items="${FriendList}">
	                       	 <div class="bg-white shadow rounded-md dark:bg-gray-900 -mx-2 lg:mx-0">
	                         	<div class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-12 mr-14 px-4 py-2 rounded shado text-white">
	                         	<p style = "margin:15px; "  class="saved_text">${post.getFirstName()}${'   '}${post.getLastName()}</p>
	                         	</div>
	                         	<div class="flex justify-between items-center px-4 py-3">
									<form action = "ShowFriend" method="post">
					 					<button name = "userID" value="${post.getUserID()}" type="submit">View Profile</button>
					 				</form >
					 				<form action="RemoveFriends" method="post">
										<button name = "userID" value="${post.getUserID()}" type="submit">Remove</button>
									</form>
								</div>
						   	</div>	
						</tag:forEach>
                    </div>
  				</div>           
		</div>
</div>

</div>
</body>
</html>