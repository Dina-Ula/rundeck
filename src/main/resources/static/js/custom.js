$(document).ready(function() {
    $(document).on('change', '.ecx_select', function() {
    	
        var id = parseInt(this.id);
        
        $('.ecx_select').each(function(index) {
            if (index > id) {
                $(this).remove();
            }
        });
        
        var selectedOption = $(this).find('option:selected').text();
        var url = "/project/job/attributes/" + selectedOption;
        var new_id = parseInt(this.id) + 1;
        
        $.ajax({
            url: url,
            dataType: "json",
            success: function(data) {
            	$.each(data, function(index, value) {
            		if (index === 0) {
            			$('#selection_holder')
            			.append('<select id="' + new_id + '" name="' + new_id + '" class="ecx_select"><option></option></select>');
            		}
        			$('#selection_holder #' + new_id).append('<option value="' + value + '">' + value + '</option>');
            	});
            },
            error: function (xhr, status, error) {
            }
        });
        
    });
});
