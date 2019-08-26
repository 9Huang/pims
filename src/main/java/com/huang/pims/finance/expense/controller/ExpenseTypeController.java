package com.huang.pims.finance.expense.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.finance.expense.model.ExpenseType;
import com.huang.pims.finance.expense.service.ExpenseTypeService;
import com.huang.pims.finance.expense.vo.ExpenseTypeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (ExpenseType)表控制层
 *
 * @author huangj
 * @since 2019-06-22 16:48:34
 */
@RestController
@RequestMapping("/expenseType")
public class ExpenseTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseTypeController.class);

    @Autowired
    private ExpenseTypeService expenseTypeService;
    
    @GetMapping(value = "/queryById/{id}")
    public ExpenseType queryById(@PathVariable Long id) {
        return expenseTypeService.queryById(id);
    }
    
    @GetMapping(value = "/queryAll")
    public List<ExpenseTypeVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<ExpenseTypeVO> expenseTypeVOList;
        if (Objects.isNull(status)) {
            expenseTypeVOList = expenseTypeService.queryAll();
        } else {
            expenseTypeVOList = expenseTypeService.queryByStatus(status);
        }
        return expenseTypeVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<ExpenseTypeVO> expenseTypeVOList;
        if (Objects.isNull(status)) {
            expenseTypeVOList = expenseTypeService.queryAll(pageNum, pageSize);
        } else {
            expenseTypeVOList = expenseTypeService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<ExpenseTypeVO> pageInfo = PageInfo.of(expenseTypeVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @PostMapping(value = "/insert")
    public ExpenseType insert(@RequestBody ExpenseType expenseType) {
        return expenseTypeService.insert(expenseType);
    }
    
    @PutMapping(value = "/update")
    public ExpenseType update(@RequestBody ExpenseType expenseType) {
        return expenseTypeService.update(expenseType);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return expenseTypeService.deleteById(id);
    }
    
    @DeleteMapping(value = "/deleteByIdLogically/{id}")
    public int deleteByIdLogically(@PathVariable Long id) {
        return expenseTypeService.deleteByIdLogically(id);
    }

}