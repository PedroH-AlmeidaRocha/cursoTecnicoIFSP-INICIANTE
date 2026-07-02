<?php
require_once "../classes/Editora.php";

$editora = new Editora();

$lista = $editora->listar();
?>

    <!DOCTYPE html>
        <html lang="pt-br">
            <head>
             <meta charset="UTF-8">
            <link rel="stylesheet" href="../css/style.css">
             <title>Lista de Editoras</title>
            </head>
        <body>

        <header>
         <h1>Editoras</h1>
         </header>

            <div class="container2">

                <a href="novo.php">voltar</a>

                <br><br>

                <table border="1">

                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                    <th>Ação</th>
                    
                </tr>

                <?php foreach($lista as $c){ ?>

                <tr>
                <td><?= $c["id_editora"] ?></td>

                <td><?= $c["nome"] ?></td>
                <td><?= $c["cidade"] ?></td>

                <td>
                   <a href="editar.php?id=<?= $c["id_editora"] ?>">Editar</a>
                       
                    </a>
                </td>

                </tr>

          <?php } ?>

         </table>

    </div>

    </body>
</html>