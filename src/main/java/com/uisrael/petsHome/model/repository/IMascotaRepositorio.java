package com.uisrael.petsHome.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.petsHome.model.entity.Mascota;

public interface IMascotaRepositorio extends JpaRepository<Mascota, Integer> {

}
