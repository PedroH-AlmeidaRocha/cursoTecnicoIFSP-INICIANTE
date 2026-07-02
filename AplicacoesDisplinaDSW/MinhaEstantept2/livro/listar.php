<?php
require_once '../classes/Livro.php';


$livro = new Livro(); 


$lista = $livro->listar(); 
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<header><h1>Livros Cadastrados</h1></header>

<div class="container2" style="max-width: 900px;">
    <a href="novo.php">Cadastrar Novo Livro</a>
    <br><br>

    <table>
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Editora</th>
                <th>sinopse</th>
                <th>Categoria</th>
                <th>Ano</th>
                <th>Ação</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($lista as $livro) { ?>
            <tr>
                <td><?= $livro['titulo'] ?></td>
                <td><?= $livro['autor'] ?></td>
                <td><?= $livro['sinopse'] ?></td>
                <td><?= $livro['nome_editora'] ?? 'Sem Editora' ?></td>
                <td><?= $livro['nome_categoria'] ?? 'Sem Categoria' ?></td>
                <td><?= $livro['ano'] ?></td>
                 <td>
                <a href="editar.php?id=<?= $livro["id"] ?>">Editar</a>
                       
                    </a>
                </td>

            </tr>
            <?php } ?>
        </tbody>
    </table>
    
    <br>
    <a href="../index.php" class="btn-voltar">Voltar ao Início</a>
</div>

</body>
</html>