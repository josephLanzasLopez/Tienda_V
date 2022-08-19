
package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServicelpml implements CategoriaService {
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<com.Tienda.domain.Categoria> getCategorias(boolean activo) {
        var lista =(List<Categoria>)categoriaDao.findAll();
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(com.Tienda.domain.Categoria categoria) {
       categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(com.Tienda.domain.Categoria categoria) {
       categoriaDao.delete(categoria);
    }

}
