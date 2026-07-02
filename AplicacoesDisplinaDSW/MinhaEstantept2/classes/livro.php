<?php

require_once "../conexao/Banco.php";

class Livro {
    public $id_livro;
    public $titulo;
    public $autor;
    public $ano;
    public $sinopse;
    public $id_editora;
    public $id_categoria;

    public function inserir() {
        $banco = new Banco();
        $conexao = $banco->conectar();
        $sql = "INSERT INTO livros(titulo, autor, ano, sinopse, id_editora, id_categoria) 
                VALUES(:titulo, :autor, :ano, :sinopse, :id_editora, :id_categoria)";
        $query = $conexao->prepare($sql);
        $query->bindValue(":titulo", $this->titulo);
        $query->bindValue(":autor", $this->autor);
        $query->bindValue(":ano", $this->ano);
        $query->bindValue(":sinopse", $this->sinopse);
        $query->bindValue(":id_editora", $this->id_editora);
        $query->bindValue(":id_categoria", $this->id_categoria);
        return $query->execute();
    }
    

public function listar(){
    $banco = new Banco();
    $conexao = $banco->conectar();
    
  
    $sql = "SELECT l.*, e.nome AS nome_editora, c.nome AS nome_categoria 
            FROM livros l
            LEFT JOIN editora e ON l.id_editora = e.id_editora
            LEFT JOIN categoria c ON l.id_categoria = c.id_categoria
            ORDER BY l.id"; 

    return $conexao->query($sql);
}

        public function editar() {
            $banco = new Banco();
            $conexao = $banco->conectar();
            
           
            $sql = "UPDATE livros SET titulo = :titulo, autor = :autor, ano = :ano, sinopse = :sinopse 
                    WHERE id = :id"; 
            
            $query = $conexao->prepare($sql);
            $query->bindValue(":titulo", $this->titulo);
            $query->bindValue(":autor", $this->autor);
            $query->bindValue(":ano", $this->ano);
            $query->bindValue(":sinopse", $this->sinopse);
            $query->bindValue(":id", $this->id_livro); 
            
            return $query->execute();
        }
           public static function buscar($id){

            $sql = "SELECT * FROM livros
                    WHERE id = :id";

                $banco = new Banco();
                $conexao = $banco->conectar();

                $query = $conexao->prepare($sql);

                $query->bindValue(":id", $id);

                $query->execute();

                return $query->fetch(PDO::FETCH_ASSOC);
            }   

}