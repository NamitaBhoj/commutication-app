<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/chat.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:08 GMT -->
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

    <style>
        @media (min-width: 1024px) {
            .container {
                max-width: 950px !important;
                padding-top: 30px !important;
            }
        }
    </style>
</head>

<body>


    <div id="wrapper">


        <div class="main_content">

            <div class="container m-auto pt-5">
                
                <h1 class="font-semibold lg:mb-6 mb-3 text-2xl"> Messages</h1>

                <div class="lg:flex lg:shadow lg:bg-white lg:space-y-0 space-y-8 rounded-md lg:-mx-0 -mx-5 overflow-hidden lg:dark:bg-gray-800">
                    <!--  message-->
                    <div class="lg:w-8/12 bg-white dark:bg-gray-800">

                         
                        <div class="border-t dark:border-gray-600">

                            <div class="lg:p-8 p-4 space-y-5">

                                <div class="flex lg:items-center">
                                    <div class="w-14 h-14 rounded-full relative flex-shrink-0">
                                        <img src="assets/images/avatars/avatar-1.jpg" alt="" class="absolute h-full rounded-full w-full">
                                    </div>
                                    <div class="text-gray-700 py-2 px-3 rounded bg-gray-100 h-full relative lg:ml-5 ml-2 lg:mr-20 dark:bg-gray-700 dark:text-white">
                                        <p class="leading-6">In ut odio libero vulputate <urna class="i uil-heart"></urna> <i class="uil-grin-tongue-wink"> </i> </p>
                                        <div class="absolute w-3 h-3 top-3 -left-1 bg-gray-100 transform rotate-45 dark:bg-gray-700"></div>
                                    </div>
                                </div>

                                <!-- my message-->
                                <div class="flex lg:items-center flex-row-reverse">
                                    <div class="w-14 h-14 rounded-full relative flex-shrink-0">
                                        <img src="assets/images/avatars/avatar-2.jpg" alt="" class="absolute h-full rounded-full w-full">
                                    </div>
                                    <div class="text-white py-2 px-3 rounded bg-blue-600 relative h-full lg:mr-5 mr-2 lg:ml-20">
                                        <p class="leading-6">Nam liber tempor cum soluta nobis eleifend option <i class="uil-grin-tongue-wink-alt"></i></p>
                                        <div class="absolute w-3 h-3 top-3 -right-1 bg-blue-600 transform rotate-45"></div>
                                    </div>
                                </div>
	                       </div>

                            <div class="border-t flex p-6 dark:border-gray-700">
                                <textarea name="message" cols="1" rows="1" placeholder="Your Message.." 
                                class="border-0 flex-1 h-10 min-h-0 resize-none min-w-0 shadow-none dark:bg-transparent"></textarea>
                                <div class="flex h-full space-x-2">
                                <form action="SendMassage" method="post"></form>
                                    <button name="friend" value = "${friend.getUserID()}" type="submit" 
                                    class="bg-blue-600 font-semibold px-6 py-2 rounded-md text-white">Send</button>
                                </div>
                            </div>

                        </div>
                    
                    </div>
                </div>
            
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


<!-- Mirrored from demo.foxthemes.net/instellohtml/chat.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:08 GMT -->
</html>