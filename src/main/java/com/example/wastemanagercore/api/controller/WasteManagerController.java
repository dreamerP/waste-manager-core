package com.example.wastemanagercore.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.wastemanagercore.core.service.WasteManagerService;
import com.example.wastemanagercore.entity.WasteManagerEntity;
import com.example.wastemanagercore.response.WasteManagerAddressResponse;
import com.example.wastemanagercore.response.WasteManagerResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/wasteManagers")
public class WasteManagerController {

	@Autowired
	private WasteManagerService wasteManagerService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{wasteManagerId}")
	@Operation(summary = "Find Waste Manager by ID", description = "Returns a single Waste Manager by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Waste Manager"),
            @ApiResponse(responseCode = "404", description = "Waste Manager not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<?> findById(@PathVariable long wasteManagerId) throws Exception {
		try {
			WasteManagerEntity wasteManagerEntity = wasteManagerService.findById(wasteManagerId);

			if (wasteManagerEntity != null) {
				WasteManagerAddressResponse address = restTemplate.getForObject(
						"http://WASTE-MANAGER-ADDRESS/" + wasteManagerEntity.getWasteManagerAddressID(),
						WasteManagerAddressResponse.class);
				WasteManagerResponse wasteManagerResponse = modelMapper.map(wasteManagerEntity,
						WasteManagerResponse.class);
				wasteManagerResponse.setWasteManagerAddressResponse(address);

				return new ResponseEntity<>(wasteManagerResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Waste manager not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/create")
    @Operation(summary = "Create Waste Manager", description = "Creates a new Waste Manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Waste Manager created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<?> create(@RequestBody WasteManagerEntity wasteManager, BindingResult bindingResult)
			throws Exception {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}

		try {
			
			wasteManagerService.create(wasteManager);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PutMapping("/update")
    @Operation(summary = "Update Waste Manager", description = "Updates an existing Waste Manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Waste Manager updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
	public ResponseEntity<?> update(@RequestBody WasteManagerEntity wasteManager, BindingResult bindingResult)
			throws Exception {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}

		try {
			wasteManagerService.update(wasteManager);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
