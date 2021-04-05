package com.egaliteSiX.beequalite.repository;

import java.util.List;

import com.egaliteSiX.beequalite.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

    public List<Postagem> findAllByTextoContainingIgnoreCase (String texto);

    @Query(value ="SELECT * FROM tb_postagem where CAST(data AS DATE) = :data", nativeQuery = true)
    public List<Postagem> findAllByDataContaining(@Param("data") String data);
}
