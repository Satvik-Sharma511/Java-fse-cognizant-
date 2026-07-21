import React from 'react';
import './App.css';

const CourseDetails = () => (
  <div className="column">
    <h2>Course Details</h2>
    <div className="item">
      <h3>Angular</h3>
      <p>4/5/2021</p>
    </div>
    <div className="item">
      <h3>React</h3>
      <p>6/3/20201</p>
    </div>
  </div>
);

const BookDetails = () => (
  <div className="column center-col">
    <h2>Book Details</h2>
    <div className="item">
      <h4>Master React</h4>
      <p>670</p>
    </div>
    <div className="item">
      <h4>Deep Dive into Angular 11</h4>
      <p>800</p>
    </div>
    <div className="item">
      <h4>Mongo Essentials</h4>
      <p>450</p>
    </div>
  </div>
);

const BlogDetails = () => (
  <div className="column">
    <h2>Blog Details</h2>
    <div className="item">
      <h3>React Learning</h3>
      <p className="author">Stephen Biz</p>
      <p className="desc">Welcome to learning React!</p>
    </div>
    <div className="item">
      <h3>Installation</h3>
      <p className="author">Schewzdenier</p>
      <p className="desc">You can install React from npm.</p>
    </div>
  </div>
);

function App() {
  // Implementing with different conditional rendering methods as requested by the lab, 
  // but keeping them all true so they display together as in the screenshot.

  const showCourses = true;
  const showBooks = true;
  const showBlogs = true;

  // 1. If-Else (Element Variable) for Courses
  let coursesComponent;
  if (showCourses) {
    coursesComponent = <CourseDetails />;
  } else {
    coursesComponent = null;
  }

  // 2. Logical && for Books
  const booksComponent = showBooks && <BookDetails />;

  return (
    <div className="container">
      {/* 1. Element Variable */}
      {coursesComponent}

      {/* 2. Logical && */}
      {booksComponent}

      {/* 3. Ternary Operator for Blogs */}
      {showBlogs ? <BlogDetails /> : null}
    </div>
  );
}

export default App;
