
package com.Tienda.service;
import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServicelpml implements ArticuloService {
    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<com.Tienda.domain.Articulo> getArticulos(boolean activo) {
        var lista =(List<Articulo>)articuloDao.findAll();
        if(activo){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(com.Tienda.domain.Articulo articulo) {
       articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(com.Tienda.domain.Articulo articulo) {
       articuloDao.delete(articulo);
    }

}
