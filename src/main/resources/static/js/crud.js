
/**
 * 重置模态框中的元素值
 * @param modal_id 模态框的id
 */
function clearModal(modal) {
    $(modal).find(".form-data").each(function(index,element) {
        var element_type = $(element).get(0).tagName.toUpperCase()
        if (element_type === "SPAN") {
            $(element).html("");
        } else {
            $(element).val("");
        }
    });
}

function getModalData(modal) {
    var formData = {};
    $(modal).find(".form-data").each(function(index,element) {
        var element_name = $(element).attr("name");
        var element_value = $(element).val();
        formData[element_name] = element_value;
    });
    return formData;
}

function queryById(id, successFun, errorFun, modal) {
    $.ajax({
        type: "get",
        url: "queryById/"+id,
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        success: function (message) {
            // if (console) {
            //     console.log(JSON.stringify(message));
            // }
            successFun(message, modal);
        },
        error: function (message) {
            errorFun(message, modal);
        }
    });
}

var successOpenSaveModal = function (message, modal) {
    $(modal).find(".form-data").each(function(index,element) {
        var element_name = $(element).attr("name");
        var element_type = $(element).get(0).tagName.toLowerCase();
        if (element_type == "input") {
            $(element).val(message[element_name]);
        } else if (element_type == "textarea") {
            $(element).text(message[element_name]);
        }

    });
    $(modal).modal({backdrop: 'static', keyboard: false});
}

var errorOpenSaveModal = function (message, modalId) {
    alert("fail:"+message);
}

var successOpenDeleteConfirmModal = function (message, modal) {
    if (message) {
        $(modal).find(".form-data").each(function(index,element) {
            var element_name = $(element).attr("name");
            var element_type = $(element).get(0).tagName.toLowerCase();
            var element_value = message[element_name];
            if (element_type == "span") {
                $(element).html(element_value);
            } else {
                $(element).val(element_value);
            }

        });
        $(modal).modal({backdrop: 'static', keyboard: false});
    } else {
        alert("未查询到该条记录的信息");
    }
}

var errorOpenDeleteConfirmModal = function (message, modalId) {
    alert("fail:"+message);
}



$(function () {

    var saveModal = $("#save_modal");

    var deleteConfirmModal = $("#delete_confirm_modal");

    $("#list_table").find("button.open_save_modal").each(function(index,element) {
        var recordId = $(element).attr("record_id");
        $(element).click(function () {
            queryById(recordId, successOpenSaveModal, errorOpenSaveModal, saveModal);
        });
    });

    $("#list_table").find("button.open_delete_confirm_modal").each(function(index,element) {
        var recordId = $(element).attr("record_id");
        $(element).click(function () {
            queryById(recordId, successOpenDeleteConfirmModal, errorOpenDeleteConfirmModal, deleteConfirmModal);
        });
    });

    $(saveModal).find("#save_button").first().click(function() {
        var formData = getModalData(saveModal);
        if (console) {
            console.log("params:",JSON.stringify(formData));
        }
        var request_url;
        var request_type;
        if (formData.id && formData.id > 0) {
            request_url = "update";
            request_type = "put";
        } else {
            request_url = "insert";
            request_type = "post";
        }
        $.ajax({
            type: request_type,
            url: request_url,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function (message) {
                if (console) {
                    console.log("results:",JSON.stringify(message));
                }
                $(saveModal).modal('hide');  //手动关闭
                clearModal(saveModal);
            },
            error: function (message) {
                alert("fail:"+message);
            }
        });
    });

    $(deleteConfirmModal).find("#delete_button").first().click(function () {
        var recordId = $(deleteConfirmModal).find("input[name='id']").val();
        $.ajax({
            type: "delete",
            url: "deleteById/"+recordId,
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            success: function (message) {
                if (message == 1) {
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
                $(deleteConfirmModal).modal('hide');
                clearModal(deleteConfirmModal);
            },
            error: function (message) {
                alert("fail:"+message);
            }
        });
    })




})
