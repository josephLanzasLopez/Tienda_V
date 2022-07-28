package com.Tienda.service;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServicelpml implements ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<com.Tienda.domain.Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(com.Tienda.domain.Cliente cliente) {
       clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(com.Tienda.domain.Cliente cliente) {
       clienteDao.delete(cliente);
    }

}
