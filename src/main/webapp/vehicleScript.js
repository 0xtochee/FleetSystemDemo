/**
 * 
 */
console.log("vehicleScript.js loaded");
function updateVehicleGroups(category) {
    console.log("updateVehicleGroups called with category:", category);
    if (category) {
        $.ajax({
            url: contextPath + '/filterVehicleGroups.action',
            data: { selectedCategory: category },
            success: function(response) {
                console.log("AJAX success, response:", response);
                $('#vehicleGroupContainer').html(response);
            },
            error: function(xhr, status, error) {
                console.error("AJAX error: " + status + " - " + error);
            }
        });
    } else {
        $('#vehicleGroupContainer').html('<select name="vehicleGroup" id="vehicleGroup" style="min-width: 70px; max-width: 140px;"><option value="">--Select--</option></select>');
    }
}

$(document).ready(function() {
    console.log("Document ready!");
});