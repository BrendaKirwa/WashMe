<?php
/**
 * Created by PhpStorm.
 * User: djkar
 * Date: 07/07/2018
 * Time: 11:42
 */?>
 <!Doctype html>
<head>
    <title>WASH ME</title>
    <link rel="shortcut icon" type="image/x-icon" href="{{asset('storage/washeme_logo')}}"/>
    {{--CSS bootstrap links--}}
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

</head>

<body>
{{--The Nav Bar--}}
<nav class="navbar navbar-inverse  navbar-fixed-top"  role="navigation" >
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a data-toggle="modal" data-target="#loginModal" style="cursor:pointer"><span class="glyphicon glyphicon-user"></span> SIGN IN</a></li>
            </ul>
        </div>
    </div>
</nav>

{{--The Login Popup--}}
<div id="loginModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"> &times;</button>
                <h4>LOGIN</h4>
            </div>

            <div class="modal-body">
                <form class="form-inline" method="post" action="/user/signin">
                    {{csrf_field()}}
                    <div class="box">
                        <div class="form">
                            <label>Username</label>
                            <input name="username" type="text" placeholder="Enter your Username or Email">
                            <label>Password</label>
                            <input name="password" type="password" placeholder="Enter your Password">
                            <input name="submit" type="submit" value="LOG IN">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>

{{--JS Bootstrap links--}}
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

{{--CSS Styling--}}
        <style>
            .box {
                background: #ffffff;
                width: 300px;
                margin: 5px auto;
                border-radius: 8px;
                padding: 5px 5px;
            }

            .box h1 {
                font-size: 28px;
                font-weight: 700;
                text-align: center;
            }

            .box .form {
                padding: 5px 0;
            }

            .box label {
                display: block;
                font-size: 14px;
                font-weight: 600;
                margin: 0;
                padding: 0 5px;
            }

            .box input[type=text],
            .box input[type=password] {
                width: 100%;
                border: 0;
                padding: 10px 16px ;
                font-size: 14px;
                font-weight: 500;
                box-shadow: inset 0 -1px  #b3b3b3;
                margin-bottom: 20px;
                outline-color: transparent;
                transition: all .3s ease;
            }

            .box input[type=text]:hover,
            .box input[type=password]:hover {
                box-shadow: inset 0 -1px  #888888;
            }

            .box input[type=text]:focus,
            .box input[type=password]:focus {
                box-shadow: inset 0 -2px  #888888;
            }

            .box a {
                display: block;
                width: 100%;
                text-align: right;
                font-size: 12px;
                margin-bottom: 20px;
            }

            .box input[type=submit] {
                display: block;
                width: 100%;
                background: linear-gradient(45deg, rgba(0, 0, 51), rgba(250, 183, 2));
                background-color: #000033;
                padding: 10px 20px;
                border: 0;
                border-radius: 50px;
                font-weight: 500;
                color: #ffffff;
                transition: all .2s ease;
                outline-color: transparent;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.25);
            }

            .box input[type=submit]:hover {
                background-color: #e09bff;
                box-shadow: 0 5px 25px -5px #b200ff;
                transform: translateY(-1px);
                text-shadow: 0 0 1px rgba(0, 0, 0, 0.5);

            }

            .box input[type=submit]:active {
                background-color: #3e005b;
                box-shadow: 0 3px 10px -2px #b200ff;
                transform: translateY(1px) scale(.99);
            }
        </style>
</html>
