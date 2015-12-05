<%-- 
    Document   : contact
    Created on : 19-Oct-2015, 22:55:13
    Author     : 24h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>NewsFeed</title>

        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- for fontawesome icon css file -->
        <link href="resources/css/font-awesome.min.css" rel="stylesheet">
        <!-- for content animate css file -->
        <link rel="stylesheet" href="resources/css/animate.css">
        <!-- google fonts  -->
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Varela' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>   
        <!-- for news ticker css file -->
        <link href="resources/css/li-scroller.css" rel="stylesheet">
        <!-- slick slider css file -->
        <link href="resources/css/slick.css" rel="stylesheet">
        <!-- for fancybox slider -->
        <link href="resources/css/jquery.fancybox.css" rel="stylesheet"> 
        <!-- website theme file -->
        <!-- <link href="resources/css/theme-red.css" rel="stylesheet"> -->

        <link href="resources/css/theme.css" rel="stylesheet">
        <!-- main site css file -->    
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <!-- End Preloader -->

        <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>

        <div class="container">
            <!-- start header section -->
            <header id="header">    
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="header_top">
                            <div class="header_top_left">
                                <ul class="top_nav">
                                    <li><a href="home.html">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </div>
                            <div class="header_top_right">
                                <p>Friday, December 05, 2014</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <div class="header_bottom">
                            <div class="logo_area">
                                <!-- for your img logo format
                                <a href="home.html" class="logo">
                                  <img src="resources/img/logo.jpg" alt="logo">
                                </a> -->
                                <!-- for your text logo format -->
                                <a href="#" class="logo">
                                    News <span>Feed</span>
                                </a> 
                            </div>
                            <div class="add_banner">
                                <a href="#"><img src="resources/img/addbanner_728x90_V1.jpg" alt="img"></a>
                            </div>
                        </div>
                    </div>
                </div>  
            </header><!-- End header section --> 
            <!-- start nav section --> 
            <section id="navArea">
                <!-- Start navbar -->
                <nav class="navbar navbar-inverse" role="navigation">      
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>          
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav main_nav">
                            <li class="active"><a href="home.html"><span class="fa fa-home desktop-home"></span><span class="mobile-show">Home</span></a></li>
                            <li><a href="#">Technology</a></li>            
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Mobile</a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Android</a></li>
                                    <li><a href="#">Samsung</a></li>
                                    <li><a href="#">Nokia</a></li>
                                    <li><a href="#">Walton Mobile</a></li>
                                    <li><a href="#">Sympony</a></li>               
                                </ul>
                            </li>
                            <li><a href="#">Laptops</a></li> 
                            <li><a href="#">Tablets</a></li> 
                            <li><a href="contact.html">Contact Us</a></li>
                            <li><a href="404.html">404 Page</a></li>
                        </ul>           
                    </div><!--/.nav-collapse -->      
                </nav>
            </section><!-- End nav section -->
            <section id="newsSection">
                <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <!-- start news sticker -->
                        <div class="latest_newsarea">      
                            <span>Latest News</span>
                            <ul id="ticker01" class="news_sticker">
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My First News Item</a></li> 
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Second News Item</a></li>
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Third News Item</a></li>
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Four News Item</a></li> 
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Five News Item</a></li>
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Six News Item</a></li>
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Seven News Item</a></li> 
                                <li><a href="#"><img src="resources/img/news_thumbnail3.jpg" alt="">My Eight News Item</a></li>
                                <li><a href="#"><img src="resources/img/news_thumbnail2.jpg" alt="">My Nine News Item</a></li>          
                            </ul>
                            <div class="social_area">
                                <ul class="social_nav">
                                    <li class="facebook"><a href="#"></a></li>
                                    <li class="twitter"><a href="#"></a></li>
                                    <li class="flickr"><a href="#"></a></li>
                                    <li class="pinterest"><a href="#"></a></li>
                                    <li class="googleplus"><a href="#"></a></li>
                                    <li class="vimeo"><a href="#"></a></li>
                                    <li class="youtube"><a href="#"></a></li>
                                    <li class="mail"><a href="mailto:info@smartnews.com"></a></li>
                                </ul>
                            </div>      
                        </div><!-- End news sticker -->
                    </div>
                </div>
            </section>   
            <!-- =========================
             //////////////This Theme Design and Developed //////////////////////
             //////////// by www.wpfreeware.com======================-->

            <!-- ==================start content body section=============== -->
            <section id="contentSection">
                <div class="row">
                    <div class="col-lg-8 col-md-8 col-sm-8">
                        <div class="left_content">
                            <!-- start contact area -->
                            <div class="contact_area">
                                <h2>Contact Us</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labolore magna aliqua. Ut enim ad minim veniam. Lorem ipsum dosectetur adipisicing elit, sed do.Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <form class="contact_form">
                                    <input class="form-control" type="text" placeholder="Name*">
                                    <input class="form-control" type="email" placeholder="Email*">
                                    <textarea class="form-control" cols="30" rows="10" placeholder="Message*"></textarea>
                                    <input type="submit" value="Send Message">                
                                </form>
                            </div>
                            <!-- End contact area -->            
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <aside class="right_content">
                            <div class="single_sidebar">
                                <h2><span>Popular Post</span></h2>
                                <ul class="spost_nav">
                                    <li>
                                        <div class="media wow fadeInDown">
                                            <a href="single_page.html" class="media-left">
                                                <img alt="img" src="resources/img/post_img1.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="single_page.html" class="catg_title"> Aliquam malesuada diam eget turpis varius 1</a>                        
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="media wow fadeInDown">
                                            <a href="single_page.html" class="media-left">
                                                <img alt="img" src="resources/img/post_img2.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="single_page.html" class="catg_title"> Aliquam malesuada diam eget turpis varius 2</a>                        
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="media wow fadeInDown">
                                            <a href="single_page.html" class="media-left">
                                                <img alt="img" src="resources/img/post_img1.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="single_page.html" class="catg_title"> Aliquam malesuada diam eget turpis varius 3</a>                        
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="media wow fadeInDown">
                                            <a href="single_page.html" class="media-left">
                                                <img alt="img" src="resources/img/post_img2.jpg">
                                            </a>
                                            <div class="media-body">
                                                <a href="single_page.html" class="catg_title"> Aliquam malesuada diam eget turpis varius 4</a>                       
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>  
                        </aside>
                    </div>
                </div>  
            </section>
            <!-- ==================End content body section=============== -->    
            <footer id="footer">       
                <div class="footer_top">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="footer_widget wow fadeInLeftBig">
                                <h2>Flickr Images</h2>

                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="footer_widget wow fadeInDown">
                                <h2>Tag</h2>
                                <ul class="tag_nav">
                                    <li><a href="#">Games</a></li>
                                    <li><a href="#">Sports</a></li>
                                    <li><a href="#">Fashion</a></li>
                                    <li><a href="#">Business</a></li>
                                    <li><a href="#">Life & Style</a></li>
                                    <li><a href="#">Technology</a></li>
                                    <li><a href="#">Photo</a></li>
                                    <li><a href="#">Slider</a></li>
                                </ul>              
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-4">
                            <div class="footer_widget wow fadeInRightBig">
                                <h2>Contact</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                                <address>
                                    Perfect News,1238 S . 123 St.Suite 25 Town City 3333,USA Phone: 123-326-789 Fax: 123-546-567 
                                </address>              
                            </div>
                        </div>
                    </div>
                </div>       
                <div class="footer_bottom">
                    <p class="copyright">
                        All Rights Reserved <a href="home.html">NewsFeed</a>
                    </p>
                    <p class="developer">Developed By <a href="http://wpfreeware.com" rel="nofollow">Wpfreeware</a></p>
                </div>    
            </footer>
        </div> <!-- /.container -->


        <!-- jQuery Library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
        <!-- For content animatin  -->
        <script src="resources/js/wow.min.js"></script>
        <!-- bootstrap js file -->
        <script src="resources/js/bootstrap.min.js"></script> 
        <!-- slick slider js file -->
        <script src="resources/js/slick.min.js"></script> 
        <!-- news ticker jquery file -->
        <script src="resources/js/jquery.li-scroller.1.0.js"></script>
        <!-- for news slider -->
        <script src="resources/js/jquery.newsTicker.min.js"></script>
        <!-- for fancybox slider -->
        <script src="resources/js/jquery.fancybox.pack.js"></script>
        <!-- custom js file include -->    
        <script src="resources/js/custom.js"></script> 
    </body>
</html>
