<?php
require_once "../classes/Livro.php";
require_once "../classes/Editora.php";
require_once "../classes/Categoria.php";

$listaEditoras = Editora::listar();
$listaCategorias = Categoria::listar();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $livro = new Livro();
    $livro->titulo = $_POST['titulo'];
    $livro->autor = $_POST['autor'];
    $livro->ano = $_POST['ano'];
    $livro->sinopse = $_POST['sinopse'];
    $livro->id_editora = $_POST['id_editora'];
    $livro->id_categoria = $_POST['id_categoria'];
    
    $livro->inserir();
    header("Location: listar.php");
    exit();
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/style.css">
    <title>Cadastro de Livro</title>
</head>
<body>
    <header>
    <h1>Cadastro de Livro</h1>
    </header>
<div class="container2">
<form method="post">
     <label>Título</label>   
    <input type="text" name="titulo"  required>
    <label>Autor</label>
    <input type="text" name="autor" required>
    <label>Ano</label>
    <input type="number" name="ano"  required>
    <label>Sinopse</label>
    <textarea name="sinopse" ></textarea>

    <select name="id_editora">
        <?php foreach($listaEditoras as $e) { echo "<option value='{$e['id_editora']}'>{$e['nome']}</option>"; } ?>
    </select>

    <select name="id_categoria">
        <?php foreach($listaCategorias as $c) { echo "<option value='{$c['id_categoria']}'>{$c['nome']}</option>"; } ?>
    </select>

    <button type="submit">Cadastrar</button>
</form>
  <a href="../index.php" class="btn-voltar">
           <h3>Voltar</h3>  
           </a>  
 </div> 
</body>
</html>