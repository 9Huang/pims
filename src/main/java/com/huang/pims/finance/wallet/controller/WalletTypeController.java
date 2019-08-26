package com.huang.pims.finance.wallet.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.finance.wallet.model.WalletType;
import com.huang.pims.finance.wallet.service.WalletTypeService;
import com.huang.pims.finance.wallet.vo.WalletTypeVO;
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
 * (WalletType)表控制层
 *
 * @author huangj
 * @since 2019-06-22 11:55:17
 */
@Controller
@RequestMapping("/walletType")
public class WalletTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletTypeController.class);

    @Autowired
    private WalletTypeService walletTypeService;
    
    @GetMapping(value = "/selectById/{id}")
    @ResponseBody
    public WalletType selectById(@PathVariable Long id) {
        return walletTypeService.selectById(id);
    }
    
    @GetMapping(value = "/queryAll")
    @ResponseBody
    public List<WalletTypeVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<WalletTypeVO> walletTypeVOList;
        if (Objects.isNull(status)) {
            walletTypeVOList = walletTypeService.queryAll();
        } else {
            walletTypeVOList = walletTypeService.queryByStatus(status);
        }
        return walletTypeVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    @ResponseBody
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<WalletTypeVO> walletTypeVOList;
        if (Objects.isNull(status)) {
            walletTypeVOList = walletTypeService.queryAll(pageNum, pageSize);
        } else {
            walletTypeVOList = walletTypeService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<WalletTypeVO> pageInfo = PageInfo.of(walletTypeVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public WalletType insert(@RequestBody WalletType walletType) {
        return walletTypeService.insert(walletType);
    }
    
    @PutMapping(value = "/update")
    @ResponseBody
    public WalletType update(@RequestBody WalletType walletType) {
        return walletTypeService.update(walletType);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    @ResponseBody
    public int deleteById(@PathVariable Long id) {
        return walletTypeService.deleteById(id);
    }
    
    @DeleteMapping(value = "/deleteByIdLogically/{id}")
    @ResponseBody
    public int deleteByIdLogically(@PathVariable Long id) {
        return walletTypeService.deleteByIdLogically(id);
    }

    @GetMapping(value = "/toList")
    public String toList(Model model, @RequestParam(value = "status", required = false) String status) {
        List<WalletTypeVO> walletTypeVOList;
        if (Objects.isNull(status)) {
            walletTypeVOList = walletTypeService.queryAll();
        } else {
            walletTypeVOList = walletTypeService.queryByStatus(status);
        }
        model.addAttribute("walletTypeList", walletTypeVOList);
        return "finance/wallet/walletTypeList";
    }


}