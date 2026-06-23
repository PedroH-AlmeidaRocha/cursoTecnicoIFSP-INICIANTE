<?php
require_once 'livros.php';

$livro = new Livro();
// Verifica se foi enviado um ID para exclusão pela URL.
// Exemplo: livroCadastrados.php?excluir=3
if(isset($_GET['excluir'])){

    $livro = new Livro();

    $livro->excluir($_GET['excluir']);

    header("Location: livroCadastrados.php");//atuliza a pagina
    exit();
}

$resultado = $livro->listarLivros();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Exibir livros cadastrados</title>
     <link rel="stylesheet" href="style.css" >
</head>
<body>



<?php if (empty($resultado)) { ?>

<div class="sem-livros">
    <h2>Nenhum livro cadastrado ainda, retorne para a tela principal.</h2>

    <a href="index.php" class="btn-voltar">
         Voltar para a página inicial
    </a>
</div>
<?php } else { ?>

    <table border="10">
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor(a)</th>
                <th>Sinopse</th>
                <th>Gênero literário</th>
                <th>Ano publicação</th>
                <th>Ações</th>
            </tr>
        </thead>

        <tbody>
            <?php foreach ($resultado as $livro) { ?>
                <tr>
                    <td><?= $livro['titulo'] ?></td>
                    <td><?= $livro['autor'] ?></td>
                    <td><?= $livro['sinopse'] ?></td>
                    <td><?= $livro['genero'] ?></td>
                    <td><?= $livro['ano'] ?></td>
                
                    <td>
                   <!-- // Cria um link que envia o ID do livro pela URL.
                    // Exemplo: livroCadastrados.php?excluir=3
                    // Quando o usuário clicar em "Excluir", o PHP poderá capturar esse ID
                    // usando $_GET['excluir'] e apagar apenas o livro correspondente.-->
                    
                    <a href="livroCadastrados.php?excluir=<?= $livro['id'] ?>"
                     onclick="return confirm('Deseja realmente excluir este livro?')"><!-- pergunta -->
                     Excluir
                    </a>
                    </td>
                </tr>
                
            <?php } ?>
        </tbody>
    </table>

    <div class="com-livros">


    <a href="index.php" class="btn-voltar2">
         Voltar para a página inicial
    </a>
</div>
<?php } ?>

</body>
</html>