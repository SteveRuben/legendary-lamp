package org.abodah.preiskeys.controller.user;

import org.abodah.preiskeys.domain.base.BaseController;
import org.abodah.preiskeys.domain.base.ResponseDTO;
import org.abodah.preiskeys.domain.user.model.RoleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "roles")
public class RoleController extends BaseController {

    @GetMapping
    @ResponseBody
    ResponseDTO<List<RoleDTO>> roles(){
        ResponseDTO response = new ResponseDTO();
        response.setData(new ArrayList<>());
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return response;
    }
}
