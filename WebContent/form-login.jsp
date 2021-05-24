<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/form-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:35 GMT -->
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

<body class="bg-gray-100">


    <div id="wrapper" class="flex flex-col justify-between h-screen">

 
        <!-- Content-->
        <div>
            <div class="lg:p-12 max-w-md max-w-xl lg:my-0 my-12 mx-auto p-6 space-y-">
                <h1 class="lg:text-3xl text-xl font-semibold  mb-6"> Log in</h1>
                <p class="mb-2 text-black text-lg"> Email or Username</p>
                
                <form name="form" action="LoginServlet" method="post"> 
                    <input type="email" name="email" placeholder="example@mydomain.com" class="bg-gray-200 mb-2 shadow-none dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;" required>
                    <input type="password"  name="password" placeholder="***********" class="bg-gray-200 mb-2 shadow-none dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;" required>
                    <div class="flex justify-between my-4">
                        <a href="#"> Forgot Your Password? </a>
                    </div>
                    <button type="submit" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full">Login</button>
                    <div class="text-center mt-5 space-x-2">
                        <p class="text-base"> Not registered? <a href="form-register.jsp" class=""> Create a account </a></p>
                    </div>
                </form>
                
            </div>
        </div>
      </div>

    <!-- Scripts
    ================================================== -->
    <script src="assets/js/tippy.all.min.js"></script>
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/uikit.js"></script>
    <script src="assets/js/simplebar.js"></script>
    <script src="assets/js/custom.js"></script>


    <script src="../../unpkg.com/ionicons%405.2.3/dist/ionicons.js"></script>
</body>
</html>