<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Sing Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Login</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="login@primer.com" class="form-control input-md" required="">
  <span class="help-block">help</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
    <span class="help-block">help</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>
  <div class="col-md-4">
  <input id="login" name="Login" value="TestUser" type="text" placeholder="text" class="primer@form.ru" required="">
  <span class="help-block">help</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Sing Up"></label>
  <div class="col-md-4">
    <button id="Sing Up" name="Sing Up" class="btn btn-primary">Sing Up</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>




