package com.huang.pims.finance.wallet.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.finance.wallet.model.WalletInstance;
import com.huang.pims.finance.wallet.service.WalletInstanceService;
import com.huang.pims.finance.wallet.vo.WalletInstanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (WalletInstance)表控制层
 *
 * @author huangj
 * @since 2019-06-22 16:42:02
 */
@RestController
@RequestMapping("/walletInstance")
public class WalletInstanceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletInstanceController.class);

    @Autowired
    private WalletInstanceService walletInstanceService;
    
    @GetMapping(value = "/queryById/{id}")
    public WalletInstance queryById(@PathVariable Long id) {
        return walletInstanceService.queryById(id);
    }
    
    @GetMapping(value = "/queryAll")
    public List<WalletInstanceVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<WalletInstanceVO> walletInstanceVOList;
        if (Objects.isNull(status)) {
            walletInstanceVOList = walletInstanceService.queryAll();
        } else {
            walletInstanceVOList = walletInstanceService.queryByStatus(status);
        }
        return walletInstanceVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<WalletInstanceVO> walletInstanceVOList;
        if (Objects.isNull(status)) {
            walletInstanceVOList = walletInstanceService.queryAll(pageNum, pageSize);
        } else {
            walletInstanceVOList = walletInstanceService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<WalletInstanceVO> pageInfo = PageInfo.of(walletInstanceVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @PostMapping(value = "/insert")
    public WalletInstance insert(@RequestBody WalletInstance walletInstance) {
        return walletInstanceService.insert(walletInstance);
    }
    
    @PutMapping(value = "/update")
    public WalletInstance update(@RequestBody WalletInstance walletInstance) {
        return walletInstanceService.update(walletInstance);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return walletInstanceService.deleteById(id);
    }
    
    @DeleteMapping(value = "/deleteByIdLogically/{id}")
    public int deleteByIdLogically(@PathVariable Long id) {
        return walletInstanceService.deleteByIdLogically(id);
    }

}