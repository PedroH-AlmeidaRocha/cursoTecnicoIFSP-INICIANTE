<?php
require_once "../classes/Categoria.php";

$categoria = new Categoria();

$lista = $categoria->listar();
?>

    <!DOCTYPE html>
        <html lang="pt-br">
            <head>
             <meta charset="UTF-8">
            <link rel="stylesheet" href="../css/style.css">
             <title>Lista de Categorias</title>
            </head>
        <body>

        <header>
         <h1>Categorias</h1>
         </header>

            <div class="container2">

                <a href="novo.php">voltar</a>

                <br><br>

                <table border="1">

                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Ação</th>
                </tr>

                <?php foreach($lista as $c){ ?>

                <tr>
                <td><?= $c["id_categoria"] ?></td>

                <td><?= $c["nome"] ?></td>

                <td>
                   <a href="editar.php?id=<?= $c["id_categoria"] ?>">Editar</a>
                       
                    </a>
                </td>

                </tr>

          <?php } ?>

         </table>

    </div>

    </body>
</html>