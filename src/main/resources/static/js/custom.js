$(document).ready(function() {
    
    $(document).on('click', '.ecx_operation_holder', function() {
	if ($("#reorder_operation").is(':checked')) {
	    disableAddBlock();
	    disableRemoveBlock();
	    disableModifyBlock();
	    disableRegexBlock();
	    
	    var num_of_options = $('.ecx_reorder_option').length;
	    var new_option = reorder_options_template.replace(/#/g, num_of_options + 1);
	    $("#ecx_dynamic_options").append(new_option);
	    
	    $("#reorder_options_holder").css("display","block");
	    $("#ecx_submit").css("display","block");
    	}
    	
    	if ($("#add_operation").is(':checked')) {
    	    disableReorderBlock();
    	    disableRemoveBlock();
    	    disableModifyBlock();
    	    disableRegexBlock();
    	    $("#selection_holder").css("display","block");
	}
    	
    	if ($("#remove_operation").is(':checked')) {
    	    disableReorderBlock();
    	    disableAddBlock();
    	    disableModifyBlock();
    	    disableRegexBlock();
    	    $("#selection_holder").css("display","block");
    	}
    	
    	if ($("#update_operation").is(':checked')) {
    	    disableReorderBlock();
    	    disableAddBlock();
    	    disableRemoveBlock();
    	    disableRegexBlock();
    	    $("#selection_holder").css("display","block");
    	}
    });
    
    //Start - Reorder Block
    $(document).on('click', '.ecx_add_options', function() {
	var num_of_options = $('.ecx_reorder_option').length;
    	var new_option = reorder_options_template.replace(/#/g, num_of_options + 1);
    	
    	$("#ecx_dynamic_options").append(new_option);
    });
    
    function disableReorderBlock () {
	$("#ecx_dynamic_options").empty();
	$("#reorder_options_holder").css("display","none");
    }
    //End - Reorder Block
    
    //Start - Add Block
    $(document).on('click', '.ecx_add_element', function() {
	$("label[for='"+this.id+"']").remove();
    });
    
    function disableAddBlock () {
	$('.ecx_dynamic_select').each(function(index) {
	    if (this.id != 'select-0') {
		$(this).remove();
	    }
	});
	
	$("#selection_holder").css("display","none");
	$("#add_element_holder").empty().css("display","none");
    }
    //End - Add Block
    
    //Start - Remove Block
    $(document).on('click', '.ecx_remove_element', function() {
	$("label[for='"+this.id+"']").remove();
    });
    
    function disableRemoveBlock () {
	$('.ecx_dynamic_select').each(function(index) {
	    if (this.id != 'select-0') {
		$(this).remove();
	    }
	});
	
	$("#selection_holder").css("display","none");
	$("#remove_element_holder").empty().css("display","none");
    }
    //End - Remove Block
    
    //Start - Modify Block
    function disableModifyBlock () {
	$('.ecx_dynamic_select').each(function(index) {
	    if (this.id != 'select-0') {
		$(this).remove();
	    }
	});
	
	$("#selection_holder").css("display","none");
	$("#update_element_holder").css("display","none");
    }
    
    $(document).on('change', '.ecx_update_id_select', function() {
	var selectedOption = $(this).find('option:selected').text();
	var updatedName = $("#update_id_value").attr('name') + selectedOption;
	$('#update_id_value').attr('name', updatedName);
    });
    
    $(document).on('change', '.ecx_update_target_select', function() {
	var selectedOption = $(this).find('option:selected').text();
	var updatedName = $("#update_target_value").attr('name') + selectedOption
	$('#update_target_value').attr('name', updatedName);
    });
    //End - Modify Block
    
    //Start - Regex Block
    function disableRegexBlock () {
	$("#regex_select").empty();
	$("#regex_element_holder").css("display","none");
    }
    $(document).on('change', '.ecx_regex_select', function() {
	var selectedOption = $(this).find('option:selected').text();
	var updatedName = $("#regex_value").attr('name') + selectedOption
	$('#regex_value').attr('name', updatedName);
    });
    //End - Regex Block
	
    $(document).on('change', '.ecx_dynamic_select', function() {
	
	if ($("#add_operation").is(':checked')) {
	    var selectedId = parseInt(this.id.replace(/select-/g, ""));
	    $('.ecx_dynamic_select').each(function(index) {
		if (index > selectedId) {
		    $(this).remove();
		}
	    });
	    
	    $("#add_element_holder").empty().css("display","none");
	    $("#ecx_submit").css("display","none");
	    
	    disableRegexBlock();
	    
	    var selectedOption = $(this).find('option:selected').text();
	    var url = "/project/job/attributes/add/" + selectedOption;
	    
	    $.ajax({
		url: url,
		dataType: "json",
		success: function(data) {
		    $.each(data["allAttributes"], function(index, value) {
			var num_of_selects = $('.ecx_dynamic_select').length - 1;
			if (index == 0) {
			    var new_select = selection_selectwithoptions_template.replace(/#/g, num_of_selects + 1).replace(/attribute/g, value);
			    $("#selection_holder").append(new_select);
			} else {
			    var new_option = options_template.replace(/attribute/g, value);
			    $("#select-" + num_of_selects).append(new_option);
			}
		    });
		    $.each(data["addAttributes"], function(index, value) {
			$("#add_element_holder").css("display","block");
			$("#ecx_submit").css("display","block");
			var new_input = add_element_template.replace(/#/g, value);
			$("#add_element_holder").append(new_input);
		    });
		    $.each(data["regexAttributes"], function(index, value) {
			$("#regex_element_holder").css("display","block");
			if (index == 0) {
			    $("#regex_select").append(options_empty_template);
			}
			
			var new_option = options_template.replace(/attribute/g, value);
			$("#regex_select").append(new_option);
		    });
		}
	    });
	}
	
	if ($("#remove_operation").is(':checked')) {
	    var selectedId = parseInt(this.id.replace(/select-/g, ""));
	    $('.ecx_dynamic_select').each(function(index) {
		if (index > selectedId) {
		    $(this).remove();
		}
	    });
	    
	    $("#remove_element_holder").empty().css("display","none");
	    $("#ecx_submit").css("display","none");
	    
	    disableRegexBlock();
	    
	    var selectedOption = $(this).find('option:selected').text();
	    var url = "/project/job/attributes/remove/" + selectedOption;
	    
	    $.ajax({
		url: url,
		dataType: "json",
		success: function(data) {
		    $.each(data["allAttributes"], function(index, value) {
			var num_of_selects = $('.ecx_dynamic_select').length - 1;
			if (index == 0) {
			    var new_select = selection_selectwithoptions_template.replace(/#/g, num_of_selects + 1).replace(/attribute/g, value);
			    $("#selection_holder").append(new_select);
			} else {
			    var new_option = options_template.replace(/attribute/g, value);
			    $("#select-" + num_of_selects).append(new_option);
			}
		    });
		    $.each(data["addAttributes"], function(index, value) {
			$("#remove_element_holder").css("display","block");
			$("#ecx_submit").css("display","block");
			var new_input = remove_element_template.replace(/#/g, value);
			$("#remove_element_holder").append(new_input);
		    });
		    $.each(data["regexAttributes"], function(index, value) {
			$("#regex_element_holder").css("display","block");
			if (index == 0) {
			    $("#regex_select").append(options_empty_template);
			}
			
			var new_option = options_template.replace(/attribute/g, value);
			$("#regex_select").append(new_option);
		    });
		}
	    });
	}
	
	if ($("#update_operation").is(':checked')) {
	    var selectedId = parseInt(this.id.replace(/select-/g, ""));
	    $('.ecx_dynamic_select').each(function(index) {
		if (index > selectedId) {
		    $(this).remove();
		}
	    });
	    
	    $("#update_id_select").empty();
	    $("#update_target_select").empty();
	    $("#update_element_holder").css("display","none");
	    $("#ecx_submit").css("display","none");
	    
	    disableRegexBlock();
	    
	    var selectedOption = $(this).find('option:selected').text();
	    var url = "/project/job/attributes/update/" + selectedOption;
	    
	    $.ajax({
		url: url,
		dataType: "json",
		success: function(data) {
		    $.each(data["allAttributes"], function(index, value) {
			var num_of_selects = $('.ecx_dynamic_select').length - 1;
			if (index == 0) {
			    var new_select = selection_selectwithoptions_template.replace(/#/g, num_of_selects + 1).replace(/attribute/g, value);
			    $("#selection_holder").append(new_select);
			} else {
			    var new_option = options_template.replace(/attribute/g, value);
			    $("#select-" + num_of_selects).append(new_option);
			}
		    });
		    $.each(data["idAttributes"], function(index, value) {
			if (index == 0) {
			    $("#update_id_select").append(options_empty_template);
			}
			
			var new_option = options_template.replace(/attribute/g, value);
			$("#update_id_select").append(new_option);
		    });
		    $.each(data["targetAttributes"], function(index, value) {
			if (index == 0) {
			    $("#update_target_select").append(options_empty_template);
			}
			
			var new_option = options_template.replace(/attribute/g, value);
			$("#update_target_select").append(new_option);
			
			$("#update_element_holder").css("display","block");
			$("#ecx_submit").css("display","block");
		    });
		    $.each(data["regexAttributes"], function(index, value) {
			$("#regex_element_holder").css("display","block");
			if (index == 0) {
			    $("#regex_select").append(options_empty_template);
			}
			
			var new_option = options_template.replace(/attribute/g, value);
			$("#regex_select").append(new_option);
		    });
		}
	    });
	}
    });
    
    var selection_selectwithoptions_template = '<select id="select-#" name="select-#" class="ecx_dynamic_select"><option></option><option value="attribute">attribute</option></select>';
    
    var add_element_template = '<label for="add_element_#"><span>#</span><input id="add_element_#" name="add-element-#" type="text" /><input id="add_element_#" class="ecx_add_element" type="button" value="Remove" /><br /><br /></label>';
    
    var remove_element_template = '<label for="remove_element_#"><span>#</span><input id="remove_element_#" name="remove-element-#" type="text" /><input id="remove_element_#" class="ecx_remove_element" type="button" value="Remove" /><br /><br /></label>';
    
    var reorder_options_template = '<label for="option #"><span>Option #</span><input type="text" class="ecx_reorder_option" name="option-#" value="" /></label>';
    
    var options_empty_template = '<option></option>';
    
    var options_template = '<option value="attribute">attribute</option>';
});