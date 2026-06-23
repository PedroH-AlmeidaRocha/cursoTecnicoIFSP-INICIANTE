<?php
    class Banco{
        private $host = "localhost";
        private $porta = "5432";
        private $nome_banco = "MinhaEstante";
        private $usuario = "postgres";
        private $senha = "1234";

        public function conectar(){

            try{
                $conn = new PDO("pgsql:host=$this->host;port=$this->porta;dbname=$this->nome_banco",$this->usuario,$this->senha);
                return $conn;
              }
                catch(PDOException $e){
                echo "Erro de conexão com o banco";
             }
         }

    }

  

class Livro {
    public $titulo;
    public $autor;
    public $sinopse;
    public $genero;
    public $ano;

    public function cadastrar($titulo, $autor, $sinopse, $genero, $ano){

        $banco = new Banco();
        $conn = $banco->conectar();

        $sql = "INSERT INTO livros
                (titulo, autor, sinopse, genero, ano)
                VALUES
                (:titulo, :autor, :sinopse, :genero, :ano)";

        $comando = $conn->prepare($sql);

        $comando->bindParam(':titulo', $titulo);
        $comando->bindParam(':autor', $autor);
        $comando->bindParam(':sinopse', $sinopse);
        $comando->bindParam(':genero', $genero);
        $comando->bindParam(':ano', $ano);

        $comando->execute();
    }

    public function listarLivros(){

        $banco = new Banco();
        $conn = $banco->conectar();

        $sql = "SELECT * FROM livros";

        return $conn->query($sql)->fetchAll();
    }

    public function excluir($id){

    $banco = new Banco();
    $conn = $banco->conectar();

    $sql = "DELETE FROM livros WHERE id = :id";

    $comando = $conn->prepare($sql);
    $comando->bindParam(':id', $id);

    $comando->execute();
}


}


?>