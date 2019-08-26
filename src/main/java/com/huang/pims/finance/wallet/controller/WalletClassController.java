package com.huang.pims.finance.wallet.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.base.vo.SelectOption;
import com.huang.pims.finance.wallet.model.WalletClass;
import com.huang.pims.finance.wallet.service.WalletClassService;
import com.huang.pims.finance.wallet.vo.WalletClassVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (WalletClass)表控制层
 *
 * @author huangj
 * @since 2019-06-22 11:22:27
 */
@Controller
@RequestMapping("/config/finance/wallet/class")
public class WalletClassController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletClassController.class);

    @Autowired
    private WalletClassService walletClassService;
    
    @GetMapping(value = "/queryById/{id}")
    @ResponseBody
    public WalletClass queryById(@PathVariable Long id) {
        return walletClassService.queryById(id);
    }
    
    @GetMapping(value = "/queryAll")
    @ResponseBody
    public List<WalletClassVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<WalletClassVO> walletClassVOList;
        if (Objects.isNull(status)) {
            walletClassVOList = walletClassService.queryAll();
        } else {
            walletClassVOList = walletClassService.queryByStatus(status);
        }
        return walletClassVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    @ResponseBody
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<WalletClassVO> walletClassVOList;
        if (Objects.isNull(status)) {
            walletClassVOList = walletClassService.queryAll(pageNum, pageSize);
        } else {
            walletClassVOList = walletClassService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<WalletClassVO> pageInfo = PageInfo.of(walletClassVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @GetMapping(value = "/queryForSelect")
    @ResponseBody
    public List<SelectOption> queryForSelect(@RequestParam(value = "status", required = false) String status) {
        return walletClassService.queryByStatusForSelect(status);
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public WalletClass insert(@RequestBody WalletClass walletClass) {
        return walletClassService.insert(walletClass);
    }
    
    @PutMapping(value = "/update")
    @ResponseBody
    public WalletClass update(@RequestBody WalletClass walletClass) {
        return walletClassService.update(walletClass);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseBody
    public int deleteById(@PathVariable Long id) {
        return walletClassService.deleteByIdLogically(id);
    }

    @GetMapping(value = "/toList")
    public String toList(Model model, @RequestParam(value = "status", required = false) String status) {
        List<WalletClassVO> walletClassVOList;
        if (Objects.isNull(status)) {
            walletClassVOList = walletClassService.queryAll();
        } else {
            walletClassVOList = walletClassService.queryByStatus(status);
        }
        model.addAttribute("walletClassList", walletClassVOList);
        return "finance/wallet/walletClassList";
    }

}