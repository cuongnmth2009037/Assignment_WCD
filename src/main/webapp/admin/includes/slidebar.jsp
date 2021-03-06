<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar sidebar-style-2">
  <div class="sidebar-wrapper scrollbar scrollbar-inner">
    <div class="sidebar-content">
      <div class="user">
        <div class="avatar-sm float-left mr-2">
          <img src="/admin/assets/img/profile.jpg" alt="/admin." class="avatar-img rounded-circle">
        </div>
        <div class="info">
          <a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									Nguyen Manh Cuong
									<span class="user-level">Administrator</span>
									<span class="caret"></span>
								</span>
          </a>
          <div class="clearfix"></div>

          <div class="collapse in" id="collapseExample">
            <ul class="nav">
              <li>
                <a href="#profile">
                  <span class="link-collapse">My Profile</span>
                </a>
              </li>
              <li>
                <a href="#edit">
                  <span class="link-collapse">Edit Profile</span>
                </a>
              </li>
              <li>
                <a href="#settings">
                  <span class="link-collapse">Settings</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <ul class="nav nav-primary">
        <li class="nav-item active">
          <a data-toggle="collapse" href="#dashboard" class="collapsed" aria-expanded="false">
            <i class="fas fa-home"></i>
            <p>Dashboard</p>
            <span class="caret"></span>
          </a>
          <div class="collapse" id="dashboard">
            <ul class="nav nav-collapse">
              <li>
                <a href="/admin/demo1/index.html">
                  <span class="sub-item">Dashboard 1</span>
                </a>
              </li>
              <li>
                <a href="/admin/demo2/index.html">
                  <span class="sub-item">Dashboard 2</span>
                </a>
              </li>
            </ul>
          </div>
        </li>
        <li class="nav-section">
							<span class="sidebar-mini-icon">
								<i class="fa fa-ellipsis-h"></i>
							</span>
          <h4 class="text-section">Components</h4>
        </li>
        <li class="nav-item">
          <a data-toggle="collapse" href="#forms">
            <i class="fas fa-pen-square"></i>
            <p>Qu???n l?? m??n ??n</p>
            <span class="caret"></span>
          </a>
          <div class="collapse" id="forms">
            <ul class="nav nav-collapse">
              <li>
                <a href="forms/forms.html">
                  <span class="sub-item">T???o m???i</span>
                </a>
              </li>
              <li>
                <a href="forms/forms.html">
                  <span class="sub-item">Danh s??ch</span>
                </a>
              </li>
            </ul>
          </div>
        </li>
        <li class="nav-item">
          <a data-toggle="collapse" href="#forms1">
            <i class="fas fa-pen-square"></i>
            <p>Qu???n l?? danh m???c</p>
            <span class="caret"></span>
          </a>
          <div class="collapse" id="forms1">
            <ul class="nav nav-collapse">
              <li>
                <a href="/category/create">
                  <span class="sub-item">T???o m???i</span>
                </a>
              </li>
              <li>
                <a href="/category/list">
                  <span class="sub-item">Danh s??ch</span>
                </a>
              </li>
            </ul>
          </div>
        </li>
      </ul>
      </ul>
    </div>
  </div>
</div>
