package com.uisrael.petsHome.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.petsHome.model.entity.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
