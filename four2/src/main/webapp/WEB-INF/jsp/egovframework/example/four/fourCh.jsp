<%@ page contentType="text/html; charset=euc-kr" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">



 
 
</script>
<form id="frm" name="frm">

</form>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="sidebar-box">
                <h3>Advertisement</h3>
                <img src="images/bootstrap2/estate/ad.jpg" class="img-responsive" alt="">
            </div><!--sidebar box-->
            <div class="sidebar-box">
                <h3>Most Recent Properties</h3>
                <div class="media">
                    <div class="media-left">
                        <div class="image">
                            <div class="content">
                                <a href="#"><i class="fa fa-search-plus"></i></a>
                                <img src="images/bootstrap2/sm-1.jpg" width="100" alt="propety">
                            </div><!--content-->
                        </div><!--image-->
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading"><a href="#">567 4th Floor</a></h4>
                        <em>Barville</em>
                        <a href="#" class="btn btn-default btn-red">Contact us</a>
                    </div>
                </div><!--media-->
                <div class="media">
                    <div class="media-left">
                        <div class="image">
                            <div class="content">
                                <a href="#"><i class="fa fa-search-plus"></i></a>
                                <img src="images/bootstrap2/sm-2.jpg" width="100" alt="propety">
                            </div><!--content-->
                        </div><!--image-->
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading"><a href="#">567 4th Floor</a></h4>
                        <em>Barville</em>
                        <a href="#" class="btn btn-default btn-red">Contact us</a>
                    </div>
                </div><!--media-->
                <div class="media">
                    <div class="media-left">
                        <div class="image">
                            <div class="content">
                                <a href="#"><i class="fa fa-search-plus"></i></a>
                                <img src="images/bootstrap2/sm-3.jpg" width="100" alt="propety">
                            </div><!--content-->
                        </div><!--image-->
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading"><a href="#">567 4th Floor</a></h4>
                        <em>Barville</em>
                        <a href="#" class="btn btn-default btn-red">Contact us</a>
                    </div>
                </div><!--media-->
            </div><!--sidebar box-->    
            <div class="sidebar-box">
                <h3>Contact Agent</h3>
                <form role="form" class="agent-form">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Name">   
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" placeholder="Email">   
                    </div>
                    <div class="form-group">
                        <section class=" select-option">
                            <select class="cs-select cs-skin-elastic">
                                <option value="" disabled selected>Agent Name</option>
                                <option value="">Agent Name</option>
                                <option value="">Agent Name</option>
                                <option value="">Agent Name</option>
                                <option value="">Agent Name</option>
                            </select>  
                        </section>
                    </div>
                    <div class="form-group">
                        <textarea class="form-control" rows="5" placeholder="Message"></textarea>
                    </div>
                    <div class="form-group text-right">
                        <!--<button type="submit" class="btn btn-red btn-lg">Send</button>-->
                        <a href="#" class="btn btn-red btn-lg">Send</a>
                    </div>
                </form>
            </div>
        </div><!--sidebar-->
        <div class="col-md-9">
            <h3 class="title-section">Our Agents</h3>
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-1.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-2.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-3.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-4.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-5.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <div class="row property-listing">
                <div class="col-sm-4 margin30">
                    <div class="image">
                        <div class="content">
                            <a href="#"><i class="fa fa-search-plus"></i></a>
                            <img src="images/bootstrap2/team-6.jpg" class="img-responsive" alt="propety">

                        </div><!--content-->
                    </div><!--image-->
                </div><!--image col-->
                <div class="col-sm-8">
                    <h3><a href="#">Agent Name</a></h3>
                    <em>Nsw, 4549</em><br>
                    <a href="#" class="btn btn-default">Contact Me</a>
                    <p>
                        Quisque non dictum eros. Praesent porta vehicula arcu eu ornare. Donec id egestas arcu. Suspendisse auctor condimentum ligula ultricies cursus. Vestibulum vel orci vel lacus rhoncus sagittis sed vitae ...
                    </p>
                    <div class="clearfix">
                        <div class="pull-right">
                            <a href="#"><i class="fa fa-chevron-circle-right"></i> More Info</a>
                        </div>
                    </div>  
                </div>
            </div><!--property listing row-->
            <nav>
                <ul class="pagination pull-right">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav><!--pagination-->
            <div class="clearfix"></div>
        </div>
    </div>
</div>