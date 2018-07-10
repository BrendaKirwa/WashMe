<?php
/**
 * Created by PhpStorm.
 * User: djkar
 * Date: 07/07/2018
 * Time: 11:31
 */?>
        <!DOCTYPE html>
<head>
    <title>ADMIN</title>
    {{--CSS links--}}
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>

<body>

{{--Sidebar Navigation--}}
<div class="tab">
    <button class="tabPanel" onclick="panelac(event, 'k1')" id="defaultOpen">CUSTOMERS</button>
    <button class="tabPanel" onclick="panelac(event, 'k2')">BRANCH MANAGERS</button>
    <button class="tabPanel" onclick="panelac(event, 'k3')">VEHICLES</button>
    <button class="tabPanel" onclick="panelac(event, 'k4')">SERVICES</button>
    <button class="tabPanel" onclick="panelac(event, 'k5')">PACKAGES</button>
    <button class="tabPanel" onclick="panelac(event, 'k6')">REPORTS</button>
</div>

{{--Content within each sidebar--}}
<div id="k1" class="panelBody">
    <h3>CUSTOMER</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#cr" data-toggle="tab">REGISTER</a>
            </li>
            <li><a href="#cd" data-toggle="tab">REMOVE</a>
            </li>
            <li><a href="#ce" data-toggle="tab">UPDATE</a>
            </li>
            <li><a href="#cs" data-toggle="tab">DISPLAY</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="cr">
                <form name="customer_form" action="" method="POST" class="form">
                    <input type="text" name="cname" id="cname" placeholder="Customer Name" class="form__text-input" autocomplete="off">
                    <input type="email" name="cemail" id="cemail" placeholder="Customer Email" class="form__text-input" autocomplete="off">
                    <input type="radio" name="cgender" id="cgender" value="Male">Male
                    <input type="radio" name="cgender" id="cgender" value="Female">Female
                    <input type="tel" name="phone" id="phone" placeholder="Phone (07........)" class="form__text-input" autocomplete="off">
                    <p>STATUS:</p>
                    <label class="switch">
                        <input name="cactivate" type="checkbox">
                        <span class="slider"></span>
                    </label><br>
                    <button class="form__btn">SAVE</button>
                </form>
            </div>
            <div class="tab-pane" id="cd">

            </div>
            <div class="tab-pane" id="ce">

            </div>
            <div class="tab-pane" id="cs">

            </div>
        </div>
    </div>
</div>

<div id="k2" class="panelBody">
    <h3>BRANCH MANAGER</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#mr" data-toggle="tab">REGISTER</a>
            </li>
            <li><a href="#md" data-toggle="tab">REMOVE</a>
            </li>
            <li><a href="#me" data-toggle="tab">UPDATE</a>
            </li>
            <li><a href="#ms" data-toggle="tab">DISPLAY</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="mr">
                <form name="mgr_form" action="/" method="POST" class="form">
                    <input type="text" name="mname" id="mname" placeholder="Manager Name" class="form__text-input" autocomplete="off">
                    <input type="email" name="memail" id="memail" placeholder="Manager Email" class="form__text-input" autocomplete="off">
                    <input type="radio" name="cgender" id="cgender" value="Male">Male
                    <input type="radio" name="cgender" id="cgender" value="Female">Female
                    <input type="tel" name="mphone" id="mphone" placeholder="Phone (07........)" class="form__text-input" autocomplete="off">
                    <p>STATUS:</p>
                    <label class="switch">
                        <input name="mactivate" type="checkbox">
                        <span class="slider"></span>
                    </label><br>
                    <button class="form__btn">REGISTER</button>
                </form>
            </div>
            <div class="tab-pane" id="md">

            </div>
            <div class="tab-pane" id="me">

            </div>
            <div class="tab-pane" id="ms">

            </div>
        </div>
    </div>
</div>

<div id="k3" class="panelBody">
    <h3>VEHICLES</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#vr" data-toggle="tab">ADD</a>
            </li>
            <li><a href="#vd" data-toggle="tab">REMOVE</a>
            </li>
            <li><a href="#ve" data-toggle="tab">UPDATE</a>
            </li>
            <li><a href="#vs" data-toggle="tab">DISPLAY</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="vr">
                <form name="vehicle_form" action="/" method="POST" class="form">
                    <input type="text" name="vtype" id="vtype" placeholder="Vehicle Type" class="form__text-input" autocomplete="off">
                    <input type="number" name="vprice" id="vprice" placeholder="Vehicle Price (Ksh)" class="form__text-input" autocomplete="off">
                    <button class="form__btn">SUBMIT</button>
                </form>
            </div>
            <div class="tab-pane" id="vd">

            </div>
            <div class="tab-pane" id="ve">

            </div>
            <div class="tab-pane" id="vs">

            </div>
        </div>
    </div>
</div>

<div id="k4" class="panelBody">
    <h3>SERVICES</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#sr" data-toggle="tab">ADD</a>
            </li>
            <li><a href="#sd" data-toggle="tab">REMOVE</a>
            </li>
            <li><a href="#se" data-toggle="tab">UPDATE</a>
            </li>
            <li><a href="#ss" data-toggle="tab">DISPLAY</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="sr">
                <form name="service_form" action="/" method="POST" class="form">
                    <input type="text" name="sname" id="sname" placeholder="Service Name" class="form__text-input" autocomplete="off">
                    <input type="number" name="sprice" id="sprice" placeholder="Service Price (Ksh)" class="form__text-input" autocomplete="off">
                    <button class="form__btn">SUBMIT</button>
                </form>
            </div>
            <div class="tab-pane" id="sd">

            </div>
            <div class="tab-pane" id="se">

            </div>
            <div class="tab-pane" id="ss">

            </div>
        </div>
    </div>
</div>

<div id="k5" class="panelBody">
    <h3>PACKAGES</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#pr" data-toggle="tab">ADD</a>
            </li>
            <li><a href="#pd" data-toggle="tab">REMOVE</a>
            </li>
            <li><a href="#pe" data-toggle="tab">UPDATE</a>
            </li>
            <li><a href="#ps" data-toggle="tab">DISPLAY</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="pr">
                <form name="package_form" action="/" method="POST" class="form">
                    <input type="text" name="name" id="name" placeholder="Package Name" class="form__text-input" autocomplete="off">
                    <input type="number" name="pprice" id="pprice" placeholder="Package Price (Ksh)" class="form__text-input" autocomplete="off">
                    <button class="form__btn">SUBMIT</button>
                </form>
            </div>
            <div class="tab-pane" id="pd">

            </div>
            <div class="tab-pane" id="pe">

            </div>
            <div class="tab-pane" id="ps">

            </div>
        </div>
    </div>
</div>

<div id="k6" class="panelBody">
    <h3>REPORTS</h3>
    {{--Tabbed Panes--}}
    <div id="exTab3" class="container">
        <ul class="nav nav-pills">
            <li class="active">
                <a href="#rc" data-toggle="tab">CUSTOMERS</a>
            </li>
            <li><a href="#rm" data-toggle="tab">BRANCH MANAGERS</a>
            </li>
            <li><a href="#rv" data-toggle="tab">VEHICLES</a>
            </li>
            <li><a href="#rs" data-toggle="tab">SERVICES</a>
            </li>
            <li><a href="#rp" data-toggle="tab">PACKAGES</a>
            </li>
        </ul>

        <div class="tab-content clearfix">
            <div class="tab-pane active" id="rc">
                <h3>Same as example 1 but we have now styled the tab's corner</h3>
            </div>
            <div class="tab-pane" id="rm">
                <h3>We use the class nav-pills instead of nav-tabs which automatically creates a background color for the tab</h3>
            </div>
            <div class="tab-pane" id="rv">
                <h3>We applied clearfix to the tab-content to rid of the gap between the tab and the content</h3>
            </div>
            <div class="tab-pane" id="rs">
                <h3>We use css to change the background color of the content to be equal to the tab</h3>
            </div>
            <div class="tab-pane" id="rp">
                <h3>We use css to change the background color of the content to be equal to the tab</h3>
            </div>
        </div>
    </div>
</div>

</body>

{{--JS links--}}
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<style>
    * {
        box-sizing: border-box;
    }
    body {
        font-family: "Lato", sans-serif;
    }

    /* Style the tab */
    .tab {
        float: left;
        background-color: #ededed;
        width: 30%;
        height: 100%;
    }

    /* Style the buttons inside the tab */
    .tab button {
        display: block;
        background-color: inherit;
        color: #4c7080;
        padding: 22px 16px;
        width: 100%;
        border: none;
        outline: none;
        text-align: left;
        cursor: pointer;
        transition: 0.3s;
        font-size: 17px;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
        background-color: #355e71;
        color: #fff;
    }

    /* Create an active/current "tab button" class */
    .tab button.active {
        background-color: #355e71;
        color: #fff;
    }

    /* Style the tab content */
    .panelBody {
        float: left;
        border: none;
        /*border: dashed 2pt black;*/
        /*border-radius: 5px;*/
        margin: 10px;
        padding: 0px 12px;
        width: 60%;
    }
    /*Form CSS*/
    .form__text-input {
        border: solid Silver 1px;
        padding: 1rem;
        width: 100%;
    }

    .form__text-input::-webkit-input-placeholder {
        color: #767676;
    }

    .form__text-input:-ms-input-placeholder {
        color: #767676;
    }

    .form__text-input::-ms-input-placeholder {
        color: #767676;
    }

    .form__text-input::placeholder {
        color: #767676;
    }

    .form__textarea {
        min-height: 5rem;
        width: 100%;
    }

    .form__btn {
        background-color: Crimson;
        border: 0;
        border-radius: 0.15rem;
        color: White;
        margin: 1.5rem 0;
        padding: 0.5rem 1rem;
    }

    input,
    textarea {
        margin-bottom: 1rem;
    }

/*For the Switch inputs*/
    .switch {
        position: relative;
        display: inline-block;
        width: 60px;
        height: 34px;
    }

    .switch input {display:none;}

    .slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
    }

    .slider:before {
        position: absolute;
        content: "";
        height: 26px;
        width: 26px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
    }

    input:checked + .slider {
        background-color: #355e71;
    }

    input:focus + .slider {
        box-shadow: 0 0 1px #355e71;
    }

    input:checked + .slider:before {
        -webkit-transform: translateX(26px);
        -ms-transform: translateX(26px);
        transform: translateX(26px);
    }

    /*Tabbed Pane*/
    #exTab3 .nav-pills > li > a {
        border-radius: 4px 4px 4px 4px ;
    }

    #exTab3 .tab-content {
        padding : 20px 20px;
    }
</style>

<script>
    function panelac(evt, panelName) {
        var i, panelBody, tabPanel;
        tabcontent = document.getElementsByClassName("panelBody");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tabPanel");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(panelName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>

</html>
