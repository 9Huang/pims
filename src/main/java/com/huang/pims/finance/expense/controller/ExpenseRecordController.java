package com.huang.pims.finance.expense.controller;

import com.github.pagehelper.PageInfo;
import com.huang.pims.finance.expense.model.ExpenseRecord;
import com.huang.pims.finance.expense.service.ExpenseRecordService;
import com.huang.pims.finance.expense.vo.ExpenseRecordVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * (ExpenseRecord)表控制层
 *
 * @author huangj
 * @since 2019-06-22 16:48:34
 */
@RestController
@RequestMapping("/expenseRecord")
public class ExpenseRecordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseRecordController.class);

    @Autowired
    private ExpenseRecordService expenseRecordService;
    
    @GetMapping(value = "/queryById/{id}")
    public ExpenseRecord queryById(@PathVariable Long id) {
        return expenseRecordService.queryById(id);
    }
    
    @GetMapping(value = "/queryAll")
    public List<ExpenseRecordVO> queryAll(@RequestParam(value = "status", required = false) String status) {
        List<ExpenseRecordVO> expenseRecordVOList;
        if (Objects.isNull(status)) {
            expenseRecordVOList = expenseRecordService.queryAll();
        } else {
            expenseRecordVOList = expenseRecordService.queryByStatus(status);
        }
        return expenseRecordVOList;
    }
    
    @GetMapping(value = "/queryAllForPage")
    public ResponseEntity queryAllForPage(@RequestParam(value = "status", required = false) String status,
                                          @RequestParam(value = "pageNum") int pageNum,
                                          @RequestParam(value = "pageSize") int pageSize) {
        List<ExpenseRecordVO> expenseRecordVOList;
        if (Objects.isNull(status)) {
            expenseRecordVOList = expenseRecordService.queryAll(pageNum, pageSize);
        } else {
            expenseRecordVOList = expenseRecordService.queryByStatus(status, pageNum, pageSize);
        }
        PageInfo<ExpenseRecordVO> pageInfo = PageInfo.of(expenseRecordVOList);
        return ResponseEntity.status(HttpStatus.OK).body(pageInfo);
    }

    @PostMapping(value = "/insert")
    public ExpenseRecord insert(@RequestBody ExpenseRecord expenseRecord) {
        return expenseRecordService.insert(expenseRecord);
    }
    
    @PutMapping(value = "/update")
    public ExpenseRecord update(@RequestBody ExpenseRecord expenseRecord) {
        return expenseRecordService.update(expenseRecord);
    }
    
    @DeleteMapping(value = "/deleteById/{id}")
    public int deleteById(@PathVariable Long id) {
        return expenseRecordService.deleteById(id);
    }
    
    @DeleteMapping(value = "/deleteByIdLogically/{id}")
    public int deleteByIdLogically(@PathVariable Long id) {
        return expenseRecordService.deleteByIdLogically(id);
    }

}