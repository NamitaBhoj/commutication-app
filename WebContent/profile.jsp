
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 



<!DOCTYPE html>

<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:21:48 GMT -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    

    <!-- Favicon -->
    <link href="assets/images/favicon.png" rel="icon" type="image/png">

    <!-- Basic Page Needs
        ================================================== -->
    <title>Instello Sharing Photos</title>
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
    <link rel="stylesheet" href="assets/css/index.css">
    
    <style>
        @media (min-width: 1024px) {
            header .header_inner {
                max-width: 980px;
            }

            .pro-container {
                max-width: 860px;
            }
        }
    </style>


</head>

<body>    
<div id="wrapper">

        <div class="main_content" >

            <header>
                <div class="header_inner">
                    <div class="left-side">

                      <div class="header_search">
                        <form action="FindFriend" method="post">
                            <input name="searchFriend" type="text" placeholder="Search..">
                            <div class="icon-search">
                                <button   type="submit" style="margin-left:700px;"
                                class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white">
	                           Search 
	                        	</button>
                            </div>
                         </form>
                        </div>
                                        
                    <div class="right-side">
                        <form action= "FeedServlet">
	                        <button   class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white">
	                            Home
	                        </button>
	                    </form>
                    </div>
                    
                    <div class="left-side">
                        <form action= "SavedPosts">
	                        <button class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white">
	                            Saved Post
	                        </button>
	                    </form>
                    </div>
                    
                    <div class="left-side">
	                        <a class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white"
	                        href="Logout">
	                            Log Out
	                        </a>
                    </div>
                  </div>
                </div>
            </header>
    
            <div class="container pro-container m-auto">
                
                <!-- profile-cover-->
                <div class="flex lg:flex-row flex-col items-center lg:py-8 lg:space-x-8">

                    <div>
                        <div class="bg-gradient-to-tr from-yellow-600 to-pink-600 p-1 rounded-full m-0.5 mr-2  w-56 h-56 relative overflow-hidden uk-transition-toggle">  
                            <img src="assets/images/avatars/user_icon1.jpg" class="bg-gray-200 border-4 border-white rounded-full w-full h-full dark:border-gray-900">
                        </div>
                    </div>
                    
                    <div class="lg:w/8/12 flex-1 flex flex-col lg:items-start items-center"> 

                        <h2 class="font-semibold lg:text-2xl text-lg mb-2"> ${details.getFirstName()}${'  '}${details.getLastName()} </h2>
                        <h3 class="lg:text-left mb-2 text-center  dark:text-gray-100"> ${details.getBio()}</h3>

                        <div class="flex font-semibold mb-3 space-x-2  dark:text-gray-10">
                        	<h6 class="font-semibold lg:text-2xl text-lg mb-2"> ${details.getEmail()} </h6>
                        </div>
                        
                        <div class="capitalize flex font-semibold space-x-3 text-center text-sm my-2">
                           <div class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white"> 
                           ${allPosts.size()} <strong class="lg:pl-2">Posts</strong></div>
                          <form action="FriendList" method="post">
                           <button class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white"
                           type="submit"> 
                          <strong class="lg:pl-2">Friends</strong>
                           </button>
                           </form>
                         </div>

                    </div>
                </div>
              
                <div class="flex items-center justify-between mt-8 space-x-3">
                    <h1 class="flex-1 font-extrabold leading-none lg:text-2xl text-lg text-gray-900 tracking-tight uk-heading-line"><span>Create Post</span></h1>
                </div>
                
                 <div class="main-grid">
					<form action="CreatePostServlet" method="POST" class="profile-form">
						<textarea name="postContent" placeholder="Whats on your mind ?" style="margin-top :15px;"></textarea>
						<input type="hidden" value="Profile" name="page">
						<button type="submit" name="createPost"  class="bg-pink-500 flex font-bold hidden hover:bg-pink-600 hover:text-white inline-block items-center lg:block max-h-10 mr-4 px-4 py-2 rounded shado text-white" style="margin-top :15px;">Create</button>	
						<br>
						<br>		
					</form>
				</div>
				
				<div class="flex items-center justify-between mt-8 space-x-3">
                    <h1 class="flex-1 font-extrabold leading-none lg:text-2xl text-lg text-gray-900 tracking-tight uk-heading-line"><span>Your Posts</span></h1>
                </div>
                <div class="my-6 grid lg:grid-cols-4 grid-cols-2 gap-1.5 hover:text-yellow-700 uk-link-reset">
                
                
                <tag:forEach var="post" items="${allPosts}">
               
                <div>
                    <div class="max-w-full lg:h-64 h-40 rounded-md relative overflow-hidden uk-transition-toggle" tabindex="0">    
					<form action="PostOprations" method="post">
					 <textarea class="saved_text" name="editText">${post.getPost()}</textarea>
					 <div class="bg-pink-500 rounded text-white" style="margin-top: 10px;">
					 <button name = "delete" value="${post.getPostid()}" type="submit" >delete</button>
					 <button name = "save" value="${post.getPostid()}" type="submit" >save</button>
					 <button name = "edit" value="${post.getPostid()}" type="submit" >edit</button>
					 </div>
					</form>
					</div>
				</div>
				</tag:forEach>
               

            </div>

        </div>

    </div>

    <script>
        
        (function (window, document, undefined) {
            'use strict';
            if (!('localStorage' in window)) return;
            var nightMode = localStorage.getItem('gmtNightMode');
            if (nightMode) {
                document.documentElement.className += ' dark';
            }
        })(window, document);
    
    
        (function (window, document, undefined) {
    
            'use strict';
    
            // Feature test
            if (!('localStorage' in window)) return;
    
            // Get our newly insert toggle
            var nightMode = document.querySelector('#night-mode');
            if (!nightMode) return;
    
            // When clicked, toggle night mode on or off
            nightMode.addEventListener('click', function (event) {
                event.preventDefault();
                document.documentElement.classList.toggle('dark');
                if (document.documentElement.classList.contains('dark')) {
                    localStorage.setItem('gmtNightMode', true);
                    return;
                }
                localStorage.removeItem('gmtNightMode');
            }, false);
    
        })(window, document);
    </script>

 <!-- Scripts
    ================================================== -->
    <script src="assets/js/tippy.all.min.js"></script>  
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/uikit.js"></script>
    <script src="assets/js/simplebar.js"></script>
    <script src="assets/js/custom.js"></script>


    <script src="../../unpkg.com/ionicons%405.2.3/dist/ionicons.js"></script>
</body>


<!-- Mirrored from demo.foxthemes.net/instellohtml/profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:01 GMT -->
</html>