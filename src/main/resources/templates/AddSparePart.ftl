<#import "macro/common.ftl" as c>


<@c.page>
    <form action="/api/manager/addSparePart" method="post">
        <label class="col-sm-2 col-form-label">Name:</label>
        <div class="col-sm-6">
            <input type="text" name="name" class="form-control" value="" />
        </div>
        <label class="col-sm-2 col-form-label">Mark:</label>
        <div class="col-sm-6">
            <input type="text" name="mark" class="form-control" value="" />
        </div>
        <label class="col-sm-2 col-form-label">Model:</label>
        <div class="col-sm-6">
            <input type="text" name="model" class="form-control" value="" />
        </div>
        <label class="col-sm-2 col-form-label">Value:</label>
        <div class="col-sm-6">
            <input type="number" name="value" class="form-control" value="" />
        </div>
        <button id="butt" type="submit">Save</button>
    </form>

</@c.page>