<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Registro</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>
<body class="bg-light">

<style>
    html, body{
        background-image: url("http://getwallpapers.com/wallpaper/full/8/d/d/1522886-mint-green-wallpapers-2560x1600-for-iphone-7.jpg");

    }

</style>


<#if userSigned == false>
    <#include "firstNavBar.ftl">
<#else>
    <#include "navbar.ftl">
</#if>
<div class="container">
    <div class="py-3 text-center">
        <h2>Log in</h2>
    </div>
    <div class="row justify-content-lg-center">
        <div class="col col-lg-3">
            <form class="needs-validation" method="post" action="/registerUser/">
                <div class="row">
                    <div class="mb-2" style="width: 100%;">
                        <div class="input-group form-group">
                            <label for="firstName">Nombre</label> &nbsp; &nbsp;

                            <div class="input-group-prepend" >
                                <span class="input-group-text"><i class="fas fa-user" style="color: #dc3545" ></i></span>
                                <input type="text" class="form-control" name="name" width="col-md-auto" required>
                            </div>
                           <!-- <i class="far fa-user-circle"></i> -->


                            <div class="invalid-feedback">
                                Primer nombre es requerido
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="mb-2" style="width: 100%;">
                        <div class="input-group form-group">
                            <label for="firstName">Nombre usuario</label> &nbsp; &nbsp;

                            <div class="input-group-prepend" >
                                <span class="input-group-text"><i class="fas fa-user-circle" style="color: #fd7e14" ></i></span>
                                <input type="text" class="form-control" name="username" width="col-md-auto" required>
                            </div>


                            <div class="invalid-feedback">
                                 Primer nombre es requerido
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div style="width: 100%;" class="mb-2">
                        <div class="input-group form-group">
                            <label for="sector">Clave</label> &nbsp; &nbsp;
                            <div class="input-group-prepend" >

                                <div class="input-group-prepend" >
                                    <span class="input-group-text"><i class="fas fa-key"  style="color: #0b2e13" ></i></span>
                                    <input type="password" class="form-control " name="password" required>
                                </div>

                                <div class="invalid-feedback">
                                    Por favor introduzca su direccion de envio.
                                </div>
                            </div>
                         </div>
                    </div>
                </div>
                <#if usuario =="admin">
                <div class="row">
                    <div style="width: 100%;" class="mb-2">
                        <input type="checkbox" name="admin" value="true"> Este usuario es <strong>Admin</strong><br>
                    </div>
                </div>
                </#if>
                <hr>
                <button class="btn btn-primary btn-md btn-block" type="submit" id="sendButton">Registrar</button>
            </form>
        </div>
    </div>
    <footer class="my-5 pt-5 text-muted text-center text-small">

    </footer>
</div>
<script src="../js/jQuery.js"></script>
<#--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->
<script src="../js/popper.js"></script>
<#--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>-->
<script src="../js/bootstrap.js"></script>
<#--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>-->

</body>
</html>