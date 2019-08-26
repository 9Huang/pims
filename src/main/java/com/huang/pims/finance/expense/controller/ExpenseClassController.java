package com.huang.pims.finance.expense.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.finance.expense.model.ExpenseClass;
import com.huang.pims.finance.expense.service.ExpenseClassService;
import com.huang.pims.finance.expense.vo.ExpenseClassVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (ExpenseClass)表控制层
 *
 * @author huangj
 * @since 2019-06-22 16:48:30
 */
@RestController
@RequestMapping("/expenseClass")
public class ExpenseClassController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseClassController.class);

    @Autowired
    private ExpenseClassService expenseClassService;
    
    @GetMapping(value = "/queryById/{id}")
    public ExpenseClass queryById(@PathVariable Long id) {
        return expenseClassService.queryById(id);
    }
    
    @GetMapping(value = "/queryAll")
    public List<ExpenseClassVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<ExpenseClassVO> expenseClassVOList;
        if (Objects.isNull(status)) {
            expenseClassVOList = expenseClassService.queryAll();
        } else {
            expenseClassVOList = expenseClassService.queryByStatus(status);
        }
        return expenseClassVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<ExpenseClassVO> expenseClassVOList;
        if (Objects.isNull(status)) {
            expenseClassVOList = expenseClassService.queryAll(pageNum, pageSize);
        } else {
            expenseClassVOList = expenseClassService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<ExpenseClassVO> pageInfo = PageInfo.of(expenseClassVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @PostMapping(value = "/insert")
    public ExpenseClass insert(@RequestBody ExpenseClass expenseClass) {
        return expenseClassService.insert(expenseClass);
    }
    
    @PutMapping(value = "/update")
    public ExpenseClass update(@RequestBody ExpenseClass expenseClass) {
        return expenseClassService.update(expenseClass);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return expenseClassService.deleteById(id);
    }
    
    @DeleteMapping(value = "/deleteByIdLogically/{id}")
    public int deleteByIdLogically(@PathVariable Long id) {
        return expenseClassService.deleteByIdLogically(id);
    }

}