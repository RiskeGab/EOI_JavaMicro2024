export class Http {
    async ajax(
        method,
        url,
        headers,
        body
    ) {
        const token = localStorage.getItem("token");
        if (token) headers = { ...headers, Authorization: "Bearer " + token };

        const resp = await fetch(url, { method, headers, body });
        if (!resp.ok) throw await resp.json();
        if (resp.status != 204) {
            return await resp.json();
        } else {
            return null;
        }
    }

    get(url) {
        return this.ajax("GET", url);
    }

    post(url, data) {
        return this.ajax(
            "POST",
            url,
            {
                "Content-Type": "application/json",
            },
            JSON.stringify(data)
        );
    }

    put(url, data) {
        return this.ajax(
            "PUT",
            url,
            {
                "Content-Type": "application/json",
            },
            JSON.stringify(data)
        );
    }

    delete(url) {
        return this.ajax("DELETE", url);
    }
}