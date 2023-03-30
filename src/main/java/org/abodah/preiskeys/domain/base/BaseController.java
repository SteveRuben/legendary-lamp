package org.abodah.preiskeys.domain.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api")
public abstract class BaseController {
}
