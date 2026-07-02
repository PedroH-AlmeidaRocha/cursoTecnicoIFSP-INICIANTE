<?php
require_once "../classes/Livro.php";

$id = $_GET["id"];
$livro = new Livro();


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $livro->id_livro = $id; // Precisamos do ID para o WHERE do UPDATE
    $livro->titulo = $_POST["titulo"];
    $livro->autor = $_POST["autor"];
    $livro->ano = $_POST["ano"];
    $livro->sinopse = $_POST["sinopse"];

    $livro->editar(); /
    
    header("Location: listar.php");
    exit();
}


$dados = Livro::buscar($id); 
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Livro</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <header><h1>Editar Livro</h1></header>

    <div class="container2">
        <form method="post">
            <label>Título:</label>
            <input type="text" name="titulo" value="<?= $dados['titulo'] ?>" required>

            <label>Autor:</label>
            <input type="text" name="autor" value="<?= $dados['autor'] ?>" required>

            <label>Ano:</label>
            <input type="text" name="ano" value="<?= $dados['ano'] ?>" required>

            <label>Sinopse:</label>
            <textarea name="sinopse" required><?= $dados['sinopse'] ?></textarea>

            <button type="submit">Salvar Alterações</button>
            <br><br>
            <a href="livroCadastrados.php">Cancelar</a>
        </form>
    </div>
</body>
</html>