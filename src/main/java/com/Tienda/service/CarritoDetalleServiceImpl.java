/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.service;

import com.Tienda.dao.CarritoDetalleDao;
import com.Tienda.domain.Articulo;
import com.Tienda.domain.CarritoDetalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joseph
 */
@Service
public class CarritoDetalleServiceImpl implements CarritoDetalleService {
    @Autowired
    CarritoDetalleDao carritoDetalleDao;
    @Override
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo) {
        return carritoDetalleDao.findByIdCarritoAndArticulo(idCarrito, articulo).orElse(null);
    }
    @Override
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito) {
        return (List<CarritoDetalle>)carritoDetalleDao.findByIdCarrito(idCarrito);
    }
    @Override
    public void save(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.save(carritoDetalle);
    }
    @Override
    public void delete(CarritoDetalle carritoDetalle) {
        carritoDetalleDao.delete(carritoDetalle);
    }
    @Override
    public void deleteAll(Long idCarrito) {
        carritoDetalleDao.deleteByIdCarrito(idCarrito);
    }     
}
