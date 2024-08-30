package com.prowings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.dto.NetworkDto;
import com.prowings.entity.Network;
import com.prowings.service.NetworkServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/network")
public class NetworkController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private NetworkServiceInterface serviceInterface;
	
	@GetMapping("/all")
	public ResponseEntity<List<Network>> allNetwork(){
		return new ResponseEntity<List<Network>>(serviceInterface.getAllNetwork(),HttpStatus.FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Network> networkById(@PathVariable Integer id){
		return new ResponseEntity<Network>(serviceInterface.networkById(id),HttpStatus.FOUND);
	}
	@PostMapping
	public ResponseEntity<NetworkDto> createNetwork(@Valid @RequestBody NetworkDto networkDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NetworkDto>(serviceInterface.createNetwork(networkDto),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNetworkById(@PathVariable Integer id){
		serviceInterface.deleteNetworkById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<NetworkDto> updateNetworkById(@Valid @PathVariable Integer id, @RequestBody NetworkDto networkDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<NetworkDto>(serviceInterface.updateNetworkById(id, networkDto),HttpStatus.UPGRADE_REQUIRED);	
	}
	@PatchMapping("/{id}")
	public ResponseEntity<NetworkDto> patchNetwork(@Valid @PathVariable Integer id, @RequestBody NetworkDto networkDto,BindingResult bindingResult ){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NetworkDto>(serviceInterface.patchNetworkById(id, networkDto),HttpStatus.UPGRADE_REQUIRED);
	}
	@GetMapping
	public ResponseEntity<Page<Network>> paginationNetwork(@RequestParam int id,@RequestParam int size){
		
		return new ResponseEntity<Page<Network>>(serviceInterface.paginationNetwork(id, size),HttpStatus.OK);
	}
	
}
