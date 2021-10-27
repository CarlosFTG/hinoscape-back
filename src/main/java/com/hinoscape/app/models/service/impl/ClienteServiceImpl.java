package com.hinoscape.app.models.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hinoscape.app.mapper.UserMapper;
import com.hinoscape.app.models.dao.IClienteDao;
import com.hinoscape.app.models.dao.IFacturaDao;
import com.hinoscape.app.models.dao.IProductoDao;
import com.hinoscape.app.models.dao.IUsuarioDao;
import com.hinoscape.app.models.dto.RoleDto;
import com.hinoscape.app.models.dto.UserDto;
import com.hinoscape.app.models.entity.Cliente;
import com.hinoscape.app.models.entity.Factura;
import com.hinoscape.app.models.entity.Producto;
import com.hinoscape.app.models.entity.RoleEntity;
import com.hinoscape.app.models.entity.UserEntity;
import com.hinoscape.app.models.service.IClienteService;
import com.hinoscape.app.models.service.IUserPointService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IUsuarioDao userDao;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserPointService userPointService;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente fetchByIdWithFacturas(Long id) {
		return clienteDao.fetchByIdWithFacturas(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id); // facturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Factura fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(Long id) {
		return facturaDao.fetchByIdWithClienteWhithItemFacturaWithProducto(id);
	}

	@Override
	public Object createUser(UserDto user, boolean admin) {
		Date currentDate = new Date();
		
		RoleDto roleDto = new RoleDto();
		
		if(admin) {
			roleDto.setAuthority("ROLE_ADMIN");
		}else {
			roleDto.setAuthority("ROLE_USER");
		}
		
		
		List<RoleDto> roles = new ArrayList<>();
		
		roles.add(roleDto);
		
		user.setRoles(roles);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		//user.setCreatedAt(currentDate);
		user.setEnabled(true);
		UserEntity userCreated = this.userDao.save(userMapper.toEntity(user));
		
		//se crean puntos para el nuevo usuario
		userPointService.createPointsNewUser(userCreated);
		return userMapper.toDto(userCreated);
	}

	@Override
	public Object getUserDetails(String userName) {
		// TODO Auto-generated method stub
		return userMapper.toDto(this.userDao.findByUsername(userName));
	}
}
