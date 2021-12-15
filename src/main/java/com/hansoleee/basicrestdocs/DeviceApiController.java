package com.hansoleee.basicrestdocs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/devices")
@RequiredArgsConstructor
public class DeviceApiController {

    private final DeviceService deviceService;

    @GetMapping(value = "/smgw", produces = "application/json; charset=UTF-8")
    public List<Smgw> getSmgwJson() {
        return deviceService.getSmgws();
    }

    @GetMapping(value = "/smgw", produces = "text/csv; charset=UTF-8")
    public String getSmgwCsv() {
        return "id,value\n1,1\n2,2\n3,3\n4,4";
    }
}
