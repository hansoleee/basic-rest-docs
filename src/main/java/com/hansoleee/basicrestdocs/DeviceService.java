package com.hansoleee.basicrestdocs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceService {

    public List<Smgw> getSmgws() {
        return List.of(
                new Smgw(1, 1),
                new Smgw(2, 2),
                new Smgw(3, 3),
                new Smgw(4, 4)
        );
    }
}
