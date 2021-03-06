package com.hinoscape.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hinoscape.app.models.dto.UserDto;
import com.hinoscape.app.models.entity.Cliente;
import com.hinoscape.app.models.entity.Factura;
import com.hinoscape.app.models.entity.Producto;

public interface IClienteService {

	public List<UserDto> findAllUsers();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public Cliente fetchByIdWithFacturas(Long id);
	
	public void delete(Long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Producto findProductoById(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long id);
	
	public Factura fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(Long id);

	public UserDto createUser(UserDto user, boolean admin);

	public Object getUserDetails(String userName);

}
