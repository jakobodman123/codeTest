import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [form1ResponseData, setForm1ResponseData] = useState(null);
  const [form2ResponseData, setForm2ResponseData] = useState(null);
  const [buttonResponseData, setButtonResponseData] = useState(null);
  const [form1Data, setForm1Data] = useState(0);
  const [form2Data, setForm2Data] = useState({ numbers: '' });

  const handleForm1Submit = async (e) => {
    e.preventDefault();
    const url = 'http://localhost:8081/api/methods/padnumberwithzeroes';
    axios.post(url, null, { params: {
      number: form1Data,
  }})
  .then(response => setForm1ResponseData(response.data.toString()))
  //.catch(err => console.warn(err))
  ;
  };


  const handleForm2Submit = async (e) => {
    e.preventDefault();
    const response = await fetch('https://example.com/form2', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(form2Data),
    });
    const data = await response.json();
    setForm2ResponseData(data);
  };

  const handleButtonSubmit = async () => {
    const response = await fetch('http://localhost:8081/api/methods/userswithreversednames');
    const data = await response.json();
    setButtonResponseData(data);
  };

  const handleForm1Change = (e) => {
    setForm1Data(Number(e.target.value));
  };

  const handleForm2Change = (e) => {
    setForm2Data({
      ...form2Data,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="container">
      <form onSubmit={handleForm1Submit}>
        <label>
          Number:
          <input type="number" value={form1Data} onChange={handleForm1Change} />
        </label>
        <button type="submit">Submit Form 1</button>
      </form>

      {form1ResponseData && (
        <div>
          <h2>Form 1 API response:</h2>
          <pre>{form1ResponseData}</pre>
        </div>
      )}

      <form onSubmit={handleForm2Submit}>
        <label>
          Numbers (comma-separated):
          <input type="text" name="numbers" value={form2Data.numbers} onChange={handleForm2Change} />
        </label>
        <button type="submit">Submit Form 2</button>
      </form>

      {form2ResponseData && (
        <div>
          <h2>Form 2 API response:</h2>
          <pre>{JSON.stringify(form2ResponseData, null, 2)}</pre>
        </div>
      )}

      <button onClick={handleButtonSubmit}>Show API Response</button>

      {buttonResponseData && (
        <div>
          <h2>Button API response:</h2>
          <pre>{JSON.stringify(buttonResponseData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default App;

