import axios from "axios";
import { useRef } from "react";

const SearchBox = ({ sendResult }) => {
  const inputRef = useRef();

  const onSearch = async (e) => {
    e.preventDefault();

    const cityName = inputRef.current.value;
    inputRef.current.value = "";

    try {
      const data = await axios.get(
        `http://localhost:8080/api/v1/weather-data?cityName=${cityName}`
      );
      sendResult({
        data: data.data,
        error: false
      });
    } catch (err) {
      sendResult({
        data: null,
        error: true
      });
    }
  };

  return (
    <div>
      <input type="text" ref={inputRef} />
      <button onClick={onSearch}>Search</button>
    </div>
  );
};

export default SearchBox;
